package com.cwlee.springsecurity.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/api/v1/hello")
    public String hello() {
        UserDetails user = User.withUsername("chanwoo.lee")
                .password("123")
                .authorities("READ")
                .build();

        return "Hello, Spring Security!";
    }
}
