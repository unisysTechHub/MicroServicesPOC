package com.poc.banking.UserService.model;

import com.poc.banking.UserService.transfer.validation.group.Domestic;
import com.poc.banking.UserService.transfer.validation.group.International;

import jakarta.validation.constraints.NotNull;

public class BeneficiaryModel {
	@NotNull(message = "Userid must not be null" )
	private String userId;
	//(External account number)
	@NotNull(message = "Account number must not be null",groups = {Domestic.class})
	private Long	AccountNumber ;
	@NotNull(message = "Bankname must not be null",groups = {Domestic.class})
	private	String	BankName;
	@NotNull(message = "Beneficiaryname must not be null",groups = {Domestic.class})
	private String	BeneficiaryName;
	@NotNull(message = "Account  type must not be null",groups = {Domestic.class})
	private String  accountType;
	@NotNull(message = "Transaction type must not be null",groups = {Domestic.class})
	private String  transferType;
	private String  transferTypeACH;
	private String	PhoneNumber;
	private String	Email;
	private String country = "US";
	private String  currency = "usd";
	@NotNull(message = "Transaction type must not be null",groups = {International.class})
	private String iban;
	private String swiftBicCode;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
