package com.cwlee.springsecurity.repository;

import com.cwlee.springsecurity.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findeUserByUsername(String username);
}
