package com.example.demo.service.model;

import java.math.BigDecimal;

import com.example.demo.model.Account;

public class Transaction {
	private String senderAccount;
    
	private String senderAccountType;

    private String receiverAccount;
    
    private String receiverAccountType;

    private BigDecimal amount;

    private TransactionType transactionType;
    
    private TransferType transferType;

    private Account senderAccountDetails;
    
    
    private Account receiverAccountDetails;
    
    private Beneficiary beneficiary;
	//private LocalDateTime 	transactionDate; 
	
	private String	description;

	public String getSenderAccount() {
		return senderAccount;
	}

	public void setSenderAccount(String senderAccount) {
		this.senderAccount = senderAccount;
	}

	public String getSenderAccountType() {
		return senderAccountType;
	}

	public void setSenderAccountType(String senderAccountType) {
		this.senderAccountType = senderAccountType;
	}

	public String getReceiverAccount() {
		return receiverAccount;
	}

	public void setReceiverAccount(String receiverAccount) {
		this.receiverAccount = receiverAccount;
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

	public Account getSenderAccountDetails() {
		return senderAccountDetails;
	}

	public void setSenderAccountDetails(Account senderAccountDetails) {
		this.senderAccountDetails = senderAccountDetails;
	}

	public Account getReceiverAccountDetails() {
		return receiverAccountDetails;
	}

	public void setReceiverAccountDetails(Account receiverAccountDetails) {
		this.receiverAccountDetails = receiverAccountDetails;
	}

	public TransferType getTransferType() {
		return transferType;
	}

	public void setTransferType(TransferType transferType) {
		this.transferType = transferType;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	

}