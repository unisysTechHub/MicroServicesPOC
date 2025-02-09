package com.example.demo.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Account")
public class Account {

    private String accountId;
    private String accountNumber;
    private String userId;
    private String accountType;
    

    // Constructors, getters and setters
    public Account(String accountId, String accountNumber,String userId, String accountType) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }


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
