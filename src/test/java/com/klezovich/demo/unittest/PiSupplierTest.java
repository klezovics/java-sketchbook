package com.klezovich.demo.unittest;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

class PiSupplierTest {

    private final PiSupplier supplier = new PiSupplier();

    @Test
    void get() {
        assertThat(supplier.get(), closeTo(3.1415, 0.00001));
    }
}