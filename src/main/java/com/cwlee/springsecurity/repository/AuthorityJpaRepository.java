package com.cwlee.springsecurity.repository;

import com.cwlee.springsecurity.repository.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityJpaRepository extends JpaRepository<AuthorityEntity, Integer> {
}
