package com.example.Greet_Api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetController {

    @Autowired
    Environment environment;

    @GetMapping("/greet")
    public String greet(){
        String port=environment.getProperty("server.port");
        return "paras" +port;
    }
}


