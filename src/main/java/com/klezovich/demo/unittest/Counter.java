package com.klezovich.demo.unittest;

import org.springframework.stereotype.Component;

@Component
public class Counter {

    private int count = 0;

    public Counter() {
    }

    public Counter(int count) {
        this.count = count;
    }

    public int add() {
        count++;
        return count;
    }

    public void reset() {
        count = 0;
    }

    public int getCount() {
        return count;
    }
}
