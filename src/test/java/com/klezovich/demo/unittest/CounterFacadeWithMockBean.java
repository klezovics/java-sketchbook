package com.klezovich.demo.unittest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = CounterFacade.class)
public class CounterFacadeWithMockBean {

    @Autowired
    private CounterFacade facade;

    @MockBean
    private Counter counter;

    @Test
    public void testFacade() {
        when(counter.add()).thenReturn(1).thenReturn(2);
        assertEquals(2, facade.addTwo());
    }
}
