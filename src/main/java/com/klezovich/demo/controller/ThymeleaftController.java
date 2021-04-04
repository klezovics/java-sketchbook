package com.klezovich.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
