package com.klezovich.demo.testcontainers;

import com.klezovich.demo.repository.Student;
import com.klezovich.demo.repository.StudentRepository;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("testcontainers")
@ContextConfiguration(initializers = {TestContainersTest.Initializer.class})
public class TestContainersTest {

    @Autowired
    private StudentRepository repository;

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = MyPostgreSqlContainer.getInstance();

    @Test
    @Transactional
    public void testInitialDbEmpty() {
        assertThat(getCount(repository.findAll()), is(0));
    }

    @Test
    @Transactional
    public void testReadStudentsFromDb() {
        insertStudents();
        assertThat(getCount(repository.findAll()), is(2));
    }

    @Test
    @Transactional
    public void testDeleteStudentsFromDb() {
        insertStudents();
        assertThat(getCount(repository.findAll()), is(2));
        repository.deleteAll();
        assertThat(getCount(repository.findAll()), is(0));
    }

    @Test
    @Transactional
    public void testUpdateStudent() {
        var student = repository.save(new Student("Arthur"));
        assertThat(student.getId(), is(1L));
        assertThat(student.getName(), is("Arthur"));

        student.setName("John");
        repository.save(student);
        assertThat(repository.findById(1L).get().getName(), is("John"));
    }

    private int getCount(Iterable iterable) {
        int count = 0;
        var iterator = iterable.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    }

    private void insertStudents() {
        repository.save(new Student("Arthur"));
        repository.save(new Student("Alex"));
    }

    static class Initializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext>
    {

        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}
