package com.poc.banking.UserService.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.poc.banking.UserService.model.Beneficiary;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class UserDetails {
	public UserDetails() {
    	
    }
    public UserDetails(String userId) {
    	this.userId = userId;
    }
	@Id
	@Column(name = "ID")
	@GeneratedValue
	int id;
	@Column(unique = true)
	String userId;
	String password;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userDetails")
	List<Account> accountList;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userDetails")
	List<TransactionsDomestic> transactionsDomestic;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userDetails")
	List<TransactionsInternal> TransactionsInternal;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userDetails")
	List<TransactionsIntra> transactionsIntra;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userDetails")
	List<TransactionsItnernational> transactionsItnernational;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userDetails")
	List<Beneficiaries> beneficiaryList;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	public List<TransactionsDomestic> getTransactionsDomestic() {
		return transactionsDomestic;
	}
	public void setTransactionsDomestic(List<TransactionsDomestic> transactionsDomestic) {
		this.transactionsDomestic = transactionsDomestic;
	}
	public List<TransactionsInternal> getTransactionsInternal() {
		return TransactionsInternal;
	}
	public void setTransactionsInternal(List<TransactionsInternal> transactionsInternal) {
		TransactionsInternal = transactionsInternal;
	}
	public List<TransactionsIntra> getTransactionsIntra() {
		return transactionsIntra;
	}
	public void setTransactionsIntra(List<TransactionsIntra> transactionsIntra) {
		this.transactionsIntra = transactionsIntra;
	}
	public List<TransactionsItnernational> getTransactionsItnernational() {
		return transactionsItnernational;
	}
	public void setTransactionsItnernational(List<TransactionsItnernational> transactionsItnernational) {
		this.transactionsItnernational = transactionsItnernational;
	}
	public List<Beneficiaries> getBeneficiaryList() {
		return beneficiaryList;
	}
	public void setBeneficiaryList(List<Beneficiaries> beneficiaryList) {
		this.beneficiaryList = beneficiaryList;
	}
	

}
