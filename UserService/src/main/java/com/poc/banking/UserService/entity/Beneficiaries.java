package com.poc.banking.UserService.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity

@Table(name = "Beneficiaries",indexes = @Index(name="index_acct_no",columnList = "AccountNumber"))
public class Beneficiaries {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long beneficiaryID; 
	
	@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,referencedColumnName="userId")
    private UserDetails userDetails;
	//(External account number)
	@Column
	Long	AccountNumber ;
	@Column
	private String  accountType;
	@Column
	private String  transferType;
	//this parameter is not required / can be deleted
	@Column
	private String  transferTypeACH;
    @Column
	String	BankName;
	@Column
    String	BeneficiaryName;
	@Column
	String	PhoneNumber;
	@Column
	String	Email;
	@Column
	String country = "US";
	@Column
	String  currency = "usd";
	@Column
	String iban;
	@Column
	String swiftBicCode;
	
	
	
	public Long getBeneficiaryID() {
		return beneficiaryID;
	}
	public void setBeneficiaryID(Long beneficiaryID) {
		this.beneficiaryID = beneficiaryID;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public Long getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getBeneficiaryName() {
		return BeneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		BeneficiaryName = beneficiaryName;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getTransferType() {
		return transferType;
	}
	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}
	public String getTransferTypeACH() {
		return transferTypeACH;
	}
	public void setTransferTypeACH(String transferTypeACH) {
		this.transferTypeACH = transferTypeACH;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getSwiftBicCode() {
		return swiftBicCode;
	}
	public void setSwiftBicCode(String swiftBicCode) {
		this.swiftBicCode = swiftBicCode;
	}
	

}
