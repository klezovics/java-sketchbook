package com.klezovich.demo.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SimpleMockTest {

    @Mock
    List<String> mockList;

    @Captor
    ArgumentCaptor<Integer> captor;

    @Test
    public void testMockInit() {
        assertThat(mockList, is(notNullValue()));
    }

    @Test
    public void testCanMockReturnValues() {
        var str = "abc";
        when(mockList.get(0)).thenReturn(str);
        assertEquals(str, mockList.get(0));
    }

    @Test
    public void testCanMockThrownExceptions() {
        when(mockList.size()).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> mockList.size());
    }

    @Test
    public void testCanVerifyMethodCalls() {
        when(mockList.get(0)).thenReturn("abc");
        when(mockList.size()).thenReturn(100);

        mockList.get(0);
        mockList.size();

        verify(mockList).get(0);
        verify(mockList).get(captor.capture());
        assertEquals(Integer.valueOf(0),captor.getValue());

        verify(mockList).size();
    }

    @Test
    public void testCanVerifyNumberOfMockMethodCalls() {
        when(mockList.get(0)).thenReturn("abc");
        mockList.get(0);
        mockList.get(0);
        verify(mockList,times(2)).get(0);
    }
}
