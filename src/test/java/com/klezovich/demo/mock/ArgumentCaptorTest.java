package com.klezovich.demo.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ArgumentCaptorTest {

    @Mock
    List<String> mockList;

    @Captor
    ArgumentCaptor<Integer> intCaptor;


    @Test
    public void testCaptorCanCaptureSingleArgument() {
        mockList.get(0);
        verify(mockList).get(intCaptor.capture());
        assertEquals(Integer.valueOf(0),intCaptor.getValue());
    }

    @Test
    public void testCaptorCanCaptureMultipleArguments() {
        mockList.get(0);
        mockList.get(1);

        verify(mockList,times(2)).get(intCaptor.capture());
        assertThat(intCaptor.getAllValues(), contains(0,1) );
    }


}
