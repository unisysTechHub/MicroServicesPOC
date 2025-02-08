package com.example.demo.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Account")
public class Account {

    private String accountId;
    private String accountName;
    private double balance;

    // Constructors, getters and setters
    public Account(String accountId, String accountName, double balance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
