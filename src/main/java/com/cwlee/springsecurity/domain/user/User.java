package com.cwlee.springsecurity.domain.user;

import com.cwlee.springsecurity.domain.Authority;
import com.cwlee.springsecurity.domain.EncryptionAlgorithm;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class User {
    private String username;
    private String password;
    private EncryptionAlgorithm algorithm;
    private List<Authority> authorities;
}
