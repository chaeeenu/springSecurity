package com.cwlee.springsecurity.controller;

import com.cwlee.springsecurity.domain.Employee;
import com.cwlee.springsecurity.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/api/v1/book/{name}")
    public Employee getBook(@PathVariable("name") String name) {
        return bookService.getBooks(name);
    }
}
