package com.yeran.demo.test;

import org.junit.Test;

import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;


/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test(){
        List mockList = mock(List.class);
        //using mock object
        mockList.add("one");
        mockList.clear();

        //verification
        verify(mockList).add("one");
        verify(mockList).clear();

        mockList.add("two");

        //stubbing,站桩
        when(mockList.get(0)).thenReturn("first");
        when(mockList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockList.get(0));

        //following throws runtime exception
        System.out.println(mockList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockList).get(0);
    }
}