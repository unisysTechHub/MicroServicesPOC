package com.poc.banking.AccountService.model;

import java.math.BigDecimal;


public class Transaction {

    private Long senderAccount;
    
    private String senderAccountType;

    private Long receiverAccount;
    
    private String receiverAccountType;

    private BigDecimal amount;

    private TransactionType transactionType;
    
    private UserDetails userDetails;
    
	//private LocalDateTime 	transactionDate; 
	
	private String	description;

	
	public String getSenderAccountType() {
		return senderAccountType;
	}

	public void setSenderAccountType(String senderAccountType) {
		this.senderAccountType = senderAccountType;
	}

	
	public String getReceiverAccountType() {
		return receiverAccountType;
	}

	public void setReceiverAccountType(String receiverAccountType) {
		this.receiverAccountType = receiverAccountType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSenderAccount() {
		return senderAccount;
	}

	public void setSenderAccount(Long senderAccount) {
		this.senderAccount = senderAccount;
	}

	public Long getReceiverAccount() {
		return receiverAccount;
	}

	public void setReceiverAccount(Long receiverAccount) {
		this.receiverAccount = receiverAccount;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
    
}
