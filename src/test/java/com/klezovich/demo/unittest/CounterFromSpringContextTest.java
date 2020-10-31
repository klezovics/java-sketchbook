package com.klezovich.demo.unittest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(classes = {Counter.class})
public class CounterFromSpringContextTest {

    @Autowired
    private Counter counter;

    @Test
    public void testAdd() {
        assertThat(counter.add(), is(1));
    }
}
