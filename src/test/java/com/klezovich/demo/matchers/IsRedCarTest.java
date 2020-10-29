package com.klezovich.demo.matchers;

import org.junit.jupiter.api.Test;

import static com.klezovich.demo.matchers.IsRedCar.redCar;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

class IsRedCarTest {

    @Test
    public void testNotCarNotMatch() {
        assertThat("water", is(not(redCar())));
    }

    @Test
    public void testOtherColorCarNotMatch() {
        assertThat(new Car("yellow"), is(not(redCar())));
    }

    @Test
    public void testRedCarMatch() {
        assertThat(new Car("red"), is(redCar()));
    }
}