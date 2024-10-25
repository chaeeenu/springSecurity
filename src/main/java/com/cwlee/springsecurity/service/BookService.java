package com.cwlee.springsecurity.service;

import com.cwlee.springsecurity.domain.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private Map<String, Employee> recodrs = Map.of(
            "danny.kim", new Employee("Danny Kim", List.of("book 1"), List.of("product owner")),
            "steve.kim", new Employee("Steve Kim", List.of("book 2"), List.of("engineer"))
    );

    @PostAuthorize("returnObject.rolse.contains('engineer')")
    public Employee getBooks(String name) {
     return recodrs.get(name);
    }
}
