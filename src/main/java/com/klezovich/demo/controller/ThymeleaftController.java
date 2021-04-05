package com.klezovich.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/tl")
public class ThymeleaftController {

    @GetMapping("/hello")
    public ModelAndView test() {
        var model = new HashMap<String, Object>();
        model.put("username", "Arthur K.");
        model.put("age", 31);

        var drinks = new ArrayList<String>();
        drinks.add("Cola");
        drinks.add("Fanta");
        drinks.add("Sprint");

        model.put("drinks", drinks);

        return new ModelAndView("hello_thymeleaf", "model", model);
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register", "register_user", new RegisterUser());
    }

    @PostMapping("/do_registration")
    public ModelAndView doRegister(@ModelAttribute("register_user") RegisterUser registerUser) {
        System.out.println("User name:"+registerUser.getUsername());
        System.out.println("Password:"+registerUser.getPassword());
        return new ModelAndView("registration_ok","register_user",registerUser);
    }

    static class RegisterUser {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


}
