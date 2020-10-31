package com.klezovich.demo.unittest;

import org.springframework.stereotype.Component;

@Component
public class CounterFacade {

    private final Counter counter;

    public CounterFacade(Counter counter) {this.counter = counter;}

    public void reset() {
        counter.reset();
    }

    public int add() {
        return counter.add();
    }

    public int addTwo() {
        counter.add();
        return counter.add();
    }
}
