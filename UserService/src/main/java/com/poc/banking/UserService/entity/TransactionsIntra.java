package com.poc.banking.UserService.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class TransactionsIntra {
	@Id
	private Timestamp transactionID;
	@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,referencedColumnName="userId")
    private UserDetails userDetails;
	private Long	fromAccountNo;
	private String  fromAccountType;
	private String  transactionType;
	private String  toAccountNo;
	private String  toAccountType;
	private Double	amount;
	private Timestamp	transactionDate; 
	private String	description;
	private	Double balanceAfterTransaction;
	
	public Timestamp getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(Timestamp transactionID) {
		this.transactionID = transactionID;
	}
	public Long getFromAccountNo() {
		return fromAccountNo;
	}
	public void setFromAccountNo(Long fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}
	public String getFromAccountType() {
		return fromAccountType;
	}
	public void setFromAccountType(String fromAccountType) {
		this.fromAccountType = fromAccountType;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getToAccountNo() {
		return toAccountNo;
	}
	public void setToAccountNo(String toAccountNo) {
		this.toAccountNo = toAccountNo;
	}
	public String getToAccountType() {
		return toAccountType;
	}
	public void setToAccountType(String toAccountType) {
		this.toAccountType = toAccountType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getBalanceAfterTransaction() {
		return balanceAfterTransaction;
	}
	public void setBalanceAfterTransaction(Double balanceAfterTransaction) {
		this.balanceAfterTransaction = balanceAfterTransaction;
	}
	
}
