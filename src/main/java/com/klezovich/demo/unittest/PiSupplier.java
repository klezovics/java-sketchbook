package com.klezovich.demo.unittest;

import java.util.function.Supplier;

public class PiSupplier implements Supplier<Double> {

    @Override
    public Double get() {
        return 3.1415;
    }
}
