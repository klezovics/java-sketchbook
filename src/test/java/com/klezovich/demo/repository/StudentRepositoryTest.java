package com.klezovich.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository repository;

    @Test
    public void testRepositoryExists() {
        assertNotNull(repository);
    }

    @Test
    public void testStudentSaved() {
        var student = new Student();
        student.setName("AK");
        assertNull(student.getId());

        var savedStudent = repository.save(student);
        var optStudent = repository.findById(savedStudent.getId());
        assertTrue(optStudent.isPresent());
        assertNotNull(optStudent.get().getId());
        assertEquals("AK",optStudent.get().getName());
    }
}