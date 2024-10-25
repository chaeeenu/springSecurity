package com.cwlee.springsecurity.controller;

import com.cwlee.springsecurity.domain.Document;
import com.cwlee.springsecurity.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;

    @GetMapping("/api/v1/document/{name}")
    public Document getDocument(@PathVariable("name") String name) {
        return documentService.getDocument(name);
    }
}
