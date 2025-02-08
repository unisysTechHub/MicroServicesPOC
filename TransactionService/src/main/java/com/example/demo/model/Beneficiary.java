package com.example.demo.model;


public class Beneficiary {
	private String userId;
	//(External account number)
	private Long	AccountNumber ;
	private	String	BankName;
	private String	BeneficiaryName;
	private String  accountType;
	private String  transferType;
	private String  transferTypeACH;
	private String	PhoneNumber;
	private String	Email;
	private String country = "US";
	private String  currency = "usd";
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
