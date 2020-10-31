package com.klezovich.demo.unittest;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class CounterTest {

    @Test
    public void testCounterInitializedToZeroByDefault() {
        assertThat(new Counter().getCount(), is(0));
    }

    @Test
    public void testCounterCorrectlyInitializedInConstructor() {
        assertThat(new Counter(10).getCount(), is(10));
    }

    @Test
    public void testCounterIncrementWorks() {
        var counter = new Counter();
        assertThat(counter.add(), is(1));
    }

    @Test
    public void testMultiplCounterIncrementWorks() {
        var counter = new Counter();
        counter.add();
        counter.add();
        counter.add();
        assertThat(counter.getCount(), is(3));
    }

    @Test
    public void testResetWorks() {
        var counter = new Counter();
        counter.add();
        assertThat(counter.getCount(), is(1));
        counter.reset();
        assertThat(counter.getCount(), is(0));
    }
}