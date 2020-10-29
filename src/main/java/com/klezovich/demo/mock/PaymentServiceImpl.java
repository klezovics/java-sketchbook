package com.klezovich.demo.mock;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public boolean processPayment(String order) {
        return true;
    }
}
