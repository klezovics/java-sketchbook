package com.klezovich.demo.controller;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RegisterUseCase {

    public Long registerUser(User user, boolean sendWelcomeEmail) {
        return new Random().nextLong();
    }
}
