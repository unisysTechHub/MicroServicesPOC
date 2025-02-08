package com.poc.banking.UserService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.poc.banking.UserService.entity.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class AccountTransactionModel {
	
	long accountId;
	
	UserDetails userDetails;
	
	String accountType;
	
	long accountNumber;
	
	String transactoinStatus = "OPEN";
	
	double  availableBalance = 0;
	
	double currrentBaalance = 0;

	
	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public double getCurrrentBaalance() {
		return currrentBaalance;
	}

	public void setCurrrentBaalance(double currrentBaalance) {
		this.currrentBaalance = currrentBaalance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTransactoinStatus() {
		return transactoinStatus;
	}

	public void setTransactoinStatus(String transactoinStatus) {
		this.transactoinStatus = transactoinStatus;
	}
	
	
	
}
