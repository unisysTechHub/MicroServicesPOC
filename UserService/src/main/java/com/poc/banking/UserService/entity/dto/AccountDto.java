package com.poc.banking.UserService.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.poc.banking.UserService.entity.Account.BillingDetails;
import com.poc.banking.UserService.entity.Account.UsBankAccount;
import com.poc.banking.UserService.entity.UserDetails;

public class AccountDto {
    private String userId;
    private String accountNumber;
    private String type;
    private Long created;
    @JsonProperty("billing_details")
    private BillingDetails billingDetails;
    @JsonProperty("us_bank_account")
    private UsBankAccount usBankAccount;
	
	
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getCreated() {
		return created;
	}
	public void setCreated(Long created) {
		this.created = created;
	}
	public BillingDetails getBillingDetails() {
		return billingDetails;
	}
	public void setBillingDetails(BillingDetails billingDetails) {
		this.billingDetails = billingDetails;
	}
	public UsBankAccount getUsBankAccount() {
		return usBankAccount;
	}
	public void setUsBankAccount(UsBankAccount usBankAccount) {
		this.usBankAccount = usBankAccount;
	}

    // Getters and Setters

    
}
