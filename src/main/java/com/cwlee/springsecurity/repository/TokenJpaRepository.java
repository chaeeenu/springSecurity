package com.cwlee.springsecurity.repository;

import com.cwlee.springsecurity.auth.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenJpaRepository extends JpaRepository<Token, Integer> {
    Optional<Token> findTokenByIdentifier(String identifier);
}
