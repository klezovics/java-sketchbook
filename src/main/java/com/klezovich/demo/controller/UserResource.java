package com.klezovich.demo.controller;

public class UserResource {

    private Long id;
    private String name;
    private String email;

    public UserResource(Long userId, String name, String email) {}

    public UserResource(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UserResource() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
