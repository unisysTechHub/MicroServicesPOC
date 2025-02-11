package com.poc.banking.UserService.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.poc.banking.UserService.entity.Account;
import com.poc.banking.UserService.entity.Beneficiaries;
import com.poc.banking.UserService.entity.UserDetails;
import com.poc.banking.UserService.enums.TransactionType;
import com.poc.banking.UserService.enums.TransferType;




public class Transaction {
private  String transactionId; 
private Long senderAccount;

private String senderAccountType;

private Long receiverAccount;

private String receiverAccountType;

private BigDecimal amount;

private TransactionType transactionType;

private TransferType transferType;

private Account senderAccountDetails;

private Account receiverAccountDetails;
private Beneficiaries beneficiary;
//private LocalDateTime 	transactionDate; 
private UserDetails userDetails; 
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

public Beneficiaries getBeneficiary() {
	return beneficiary;
}

public void setBeneficiary(Beneficiaries beneficiary) {
	this.beneficiary = beneficiary;
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

public TransferType getTransferType() {
	return transferType;
}

public void setTransferType(TransferType transferType) {
	this.transferType = transferType;
}

public String getTransactionId() {
	return transactionId;
}

public void setTransactionId(String transactionId) {
	this.transactionId = transactionId;
}

public UserDetails getUserDetails() {
	return userDetails;
}

public void setUserDetails(UserDetails userDetails) {
	this.userDetails = userDetails;
}


	
	
	
	

}
