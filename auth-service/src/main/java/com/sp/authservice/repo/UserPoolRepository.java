package com.sp.authservice.repo;

import com.sp.authservice.domain.UserPool;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPoolRepository extends JpaRepository<UserPool, Long> {
    Optional<UserPool> findByEmail(String email);

    Optional<UserPool> findByPhoneNo(String phoneNo);
}