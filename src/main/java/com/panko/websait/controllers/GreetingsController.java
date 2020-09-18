package com.panko.websait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingsController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(required = false) String name, Map<String, Object> model) {

        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {

        return "main";
    }
}
