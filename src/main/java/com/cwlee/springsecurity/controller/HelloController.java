package com.cwlee.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/api/v1/hello")
    public String getHello() {
        return "GET hello";
    }

    @PostMapping("/api/v1/hello")
    public String postHello() {
        return "POST hello";
    }

    @GetMapping("/api/v1/hello/hi")
    public String getHello2() {
        return "GET hello 2";
    }

    @GetMapping("/api/v1/hello/hi/hola")
    public String getHello3() {
        return "GET hello 3";
    }

    @GetMapping("/product/{code}")
    public String productCode(@PathVariable String code) {
        return code;
    }
}
