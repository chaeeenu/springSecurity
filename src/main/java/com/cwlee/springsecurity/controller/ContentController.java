package com.cwlee.springsecurity.controller;

import com.cwlee.springsecurity.domain.Content;
import com.cwlee.springsecurity.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/api/v1/contents/{name}")
    public List<Content> findAllV1(@PathVariable("name") String name) {
        return contentService.findAllByName(name);
    }

    @GetMapping("/api/v2/contents/{name}")
    public List<Content> findAllV2(@PathVariable("name") String name) {
        return contentService.findAllByNameWithAuthentication(name);
    }
}
