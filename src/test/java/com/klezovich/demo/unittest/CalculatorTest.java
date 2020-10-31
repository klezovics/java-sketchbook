package com.klezovich.demo.unittest;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testAddTwoNumbers() {
        assertThat(calc.add(2, 2), is(4));
    }

    @Test
    public void testSubstactTwoNumbers() {
        assertThat(calc.substract(4, 2), is(2));
    }
}