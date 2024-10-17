package com.cwlee.springsecurity.service;

import com.cwlee.springsecurity.domain.user.CreateUser;
import com.cwlee.springsecurity.domain.user.User;
import com.cwlee.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String register(CreateUser create) {
        if(userRepository.userExists(create.getUsername())) {
            throw new RuntimeException(String.format("User [%s] already exists", create.getUsername()));
        }

        return userRepository.create(create).getUsername();
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
