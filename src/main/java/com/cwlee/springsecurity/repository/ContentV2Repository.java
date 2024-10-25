package com.cwlee.springsecurity.repository;

import com.cwlee.springsecurity.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentV2Repository extends JpaRepository<Content, Integer> {
    @Query("SELECT c FROM Content c WHERE c.name LIKE %:name% AND c.owner=?#{authentication.name}")
    List<Content> findContentsByNameContaining(@Param("name") String name);
}
