package com.banking.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.auth.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
