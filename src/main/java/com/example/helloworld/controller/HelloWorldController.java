package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String sendGreetings() {
        return "Hello, World!";
    }
    @GetMapping("/hello2")
    public String sendGreetings2() {
        return "Hello, World!2";
    }
    @GetMapping("/hello3")
    public String sendGreetings3() {
        return "Hello, World!3";
    }
     @GetMapping("/hello4")
    public String sendGreetings4() {
        return "Hello, World!4";
    }
}
