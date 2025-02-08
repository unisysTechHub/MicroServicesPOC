package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repo.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Save account to Redis
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    // Find account by accountId
    public Account getAccountById(String accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    // Delete account by accountId
    public void deleteAccount(String accountId) {
        accountRepository.deleteById(accountId);
    }
}
