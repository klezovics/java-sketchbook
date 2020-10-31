package com.klezovich.demo.unittest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@SpringBootTest(classes = {CounterFacade.class, Counter.class})
public class CounterFacadeFromSpringContextTest {

    @Autowired
    private CounterFacade facade;

    @Test
    public void testFacade() {
        assertThat(facade.addTwo(), is(2));
    }
}
