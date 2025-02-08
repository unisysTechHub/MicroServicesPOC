package com.poc.banking.AccountService.entity;
import java.math.BigDecimal;

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
	Long accountId;
	@JsonBackReference
	@JoinColumn(name = "USERDETAILS_ID")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	UserDetails userDetails;
	
	@Column(name = "Account_Type")
	String accountType;
	
	@Column(name = "Account_Number")
	long accountNumber;
	
	@Column(name = "Transaction_Status")
	String transactoinStatus;
	
	@Column(name = "Available_BAL")
	BigDecimal  availableBalance;
	
	@Column(name = "Current_BAL")
	double currrentBaalance;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
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

	

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
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
