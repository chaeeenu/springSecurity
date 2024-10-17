package com.cwlee.springsecurity.domain;

import lombok.Getter;

@Getter
public enum EncryptionAlgorithm {
    BCRYPT,
    SCRYPT,
    ;
}
