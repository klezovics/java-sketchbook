package com.klezovich.demo.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    @Mock
    List<String> mockedList;

    @Spy
    PaymentService mockedPaymentService = new PaymentServiceImpl();

    @Captor
    ArgumentCaptor<String> argCaptor;

    @Mock
    Inner inner;

    @InjectMocks
    Outer outer;

    static class Outer {
        private final Inner inner;

        Outer(Inner inner) {this.inner = inner;}

        String g() {
            return inner.f();
        }
    }

    static class Inner {
        String f() {
            return "inner";
        }
    }

    @Test
    public void testInjectMocks() {
        when(inner.f()).thenReturn("mockinner");
        assertEquals("mockinner", outer.g());
    }

    @Before
    public void setupMocks() {
    }

    @Test
    public void testCaptor() {
        mockedList.add("two");
        verify(mockedList).add(argCaptor.capture());
        assertEquals("two",argCaptor.getValue());
    }

    @Test
    public void testSpy() {
        //Uses real method by default
        assertTrue(mockedPaymentService.processPayment("abc"));

        //However, we can also fake some results
        when(mockedPaymentService.processPayment("falseorder")).thenReturn(false);
        assertFalse(mockedPaymentService.processPayment("falseorder"));
    }

    @Test
    public void whenUseMockAnnotation_thenMockIsInjected() {
        mockedList.add("one");
        verify(mockedList).add("one");
        assertEquals(0, mockedList.size());

        Mockito.when(mockedList.size()).thenReturn(100);
        assertEquals(100, mockedList.size());

        mockedPaymentService.processPayment("abc");
        verify(mockedPaymentService).processPayment("abc");

        when(mockedPaymentService.processPayment("abc")).thenReturn(false);
        assertFalse(mockedPaymentService.processPayment("abc"));
    }
}
