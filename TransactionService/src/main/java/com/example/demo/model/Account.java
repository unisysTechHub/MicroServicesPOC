package com.example.demo.model;

import org.springframework.data.redis.core.RedisHash;

import org.springframework.data.annotation.Id;
import java.io.Serializable;

@RedisHash("Account")
public class Account implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private String accountId;
    private String accountNumber;
    private String userId;
    private String accountType;

    // No-argument constructor (required by Spring Data Redis)
    public Account() {}

    // All-arguments constructor
    public Account(String accountId, String accountNumber, String userId, String accountType) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.accountType = accountType;
    }

    // Getters and Setters
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
