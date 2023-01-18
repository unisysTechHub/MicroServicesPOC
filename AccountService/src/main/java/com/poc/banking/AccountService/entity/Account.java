package com.poc.banking.AccountService.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Account {
	@Id
	@Column(name = "ID")
	int accountId;
	@JsonBackReference
	@JoinColumn(name = "USERDETAILS_ID")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	UserDetails userDetails;
	
	@Column(name = "Account_Type")
	String accountType;
	
	@Column(name = "Available_BAL")
	double  availableBalance;
	
	@Column(name = "Current_BAL")
	double currrentBaalance;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
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
	
	
	
}
