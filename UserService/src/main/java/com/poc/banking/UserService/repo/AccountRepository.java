package com.poc.banking.UserService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.banking.UserService.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
