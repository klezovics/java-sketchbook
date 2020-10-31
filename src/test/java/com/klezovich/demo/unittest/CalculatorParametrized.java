package com.klezovich.demo.unittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class CalculatorParametrized {

    private final Calculator calc = new Calculator();

    @Parameter(value = 0)
    public int x;

    @Parameter(value = 1)
    public int y;

    @Parameter(value = 2)
    public int xySum;

    @Test
    public void testCalcParametrized() {
        assertThat(calc.add(x, y), is(xySum));
    }

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> params = new ArrayList();
        params.add(new Object[]{1, 2, 3});
        params.add(new Object[]{0, 0, 0});
        params.add(new Object[]{5, 6, 11});
        return params;
    }
}
