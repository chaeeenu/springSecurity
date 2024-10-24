package com.cwlee.springsecurity.service;

import com.cwlee.springsecurity.domain.Document;
import com.cwlee.springsecurity.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;

    @PostAuthorize("hasPermission(returnObject, 'ROLE_admin')")
    public Document getDocument(String name) {
        return documentRepository.findDocumentByName(name);
    }

}
