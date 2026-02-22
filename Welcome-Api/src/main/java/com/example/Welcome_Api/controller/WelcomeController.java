package com.example.Welcome_Api.controller;


import com.example.Welcome_Api.repo.GreetApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WelcomeController {

    @Autowired
    GreetApiClient greetApiClient;

    @GetMapping("/welcome")
    public String welcome(){
        String res = greetApiClient.invokeGreetApi();
        return "Good morning, "+res;
    }

}
