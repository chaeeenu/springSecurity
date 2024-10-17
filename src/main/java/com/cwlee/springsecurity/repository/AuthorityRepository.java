package com.cwlee.springsecurity.repository;

import com.cwlee.springsecurity.domain.Authority;
import com.cwlee.springsecurity.repository.entity.AuthorityEntity;
import com.cwlee.springsecurity.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class AuthorityRepository {
    private final AuthorityJpaRepository authorityJpaRepository;

    @Transactional
    public Authority create(String name, UserEntity user){
        return authorityJpaRepository.save(new AuthorityEntity(name,user))
                .toAuthority();
    }
}
