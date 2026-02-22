package com.example.Welcome_Api.repo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GREET-API")
public interface GreetApiClient {

    @GetMapping("/api/greet")
    public String invokeGreetApi();
}
