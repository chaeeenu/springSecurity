package com.cwlee.springsecurity.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HelloRequestBody {

    private String id;

    @CustomEncryption
    private String password;
}
