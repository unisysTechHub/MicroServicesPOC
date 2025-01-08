package com.poc.banking.UserService.transfer.response;

import com.poc.banking.UserService.model.Beneficiary;
import com.poc.banking.UserService.response.BaseResponse;

public class BeneficiaryResponseModel extends BaseResponse {
	Beneficiary beneficiary;
//    private String userId;
//    private Long accountNumber;
//    private String bankName;
//    private String beneficiaryName;
//    private String accountType;
//    private String transferType;
//    private String transferTypeACH;
//    private String phoneNumber;
//    private String email;
//    private String country = "US";
//    private String currency = "usd";
//    private String iban;
//    private String swiftBicCode;
    	public BeneficiaryResponseModel(String message, String responseCode) {
		
		super(message,responseCode);
	}

    // Private constructor to enforce the use of the Builder
    private BeneficiaryResponseModel(Builder builder) {
    	Beneficiary beneficiary = new Beneficiary();

        beneficiary.setUserId(builder.userId);
        beneficiary.setAccountNumber(builder.accountNumber);
        beneficiary.setBankName(builder.bankName);
        beneficiary.setBankName(builder.beneficiaryName);
        beneficiary.setAccountType( builder.accountType);
        beneficiary.setTransferType(builder.transferType);
        beneficiary.setTransferTypeACH(builder.transferTypeACH); 
        beneficiary.setPhoneNumber(builder.phoneNumber);
        beneficiary.setEmail(builder.email);
        beneficiary.setCountry(builder.country); 
        beneficiary.setCurrency(builder.currency); 
        beneficiary.setIban(builder.iban);
        beneficiary.setSwiftBicCode(builder.swiftBicCode);
        this.beneficiary = beneficiary;
    }

    public BeneficiaryResponseModel() {
		// TODO Auto-generated constructor stub
	}
    

	// Getter methods for all fields
//    public String getUserId() {
//        return userId;
//    }
//
//    public Long getAccountNumber() {
//        return accountNumber;
//    }
//
//    public String getBankName() {
//        return bankName;
//    }
//
//    public String getBeneficiaryName() {
//        return beneficiaryName;
//    }
//
//    public String getAccountType() {
//        return accountType;
//    }
//
//    public String getTransferType() {
//        return transferType;
//    }
//
//    public String getTransferTypeACH() {
//        return transferTypeACH;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public String getIban() {
//        return iban;
//    }
//
//    public String getSwiftBicCode() {
//        return swiftBicCode;
//    }

    public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}


	// Builder class
    public static class Builder {
        private String userId;
        private Long accountNumber;
        private String bankName;
        private String beneficiaryName;
        private String accountType;
        private String transferType;
        private String transferTypeACH;
        private String phoneNumber;
        private String email;
        private String country = "US";
        private String currency = "usd";
        private String iban;
        private String swiftBicCode;
        
        public Builder(){}
        
        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder accountNumber(Long accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder bankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            this.beneficiaryName = beneficiaryName;
            return this;
        }

        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder transferType(String transferType) {
            this.transferType = transferType;
            return this;
        }

        public Builder transferTypeACH(String transferTypeACH) {
            this.transferTypeACH = transferTypeACH;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder iban(String iban) {
            this.iban = iban;
            return this;
        }

        public Builder swiftBicCode(String swiftBicCode) {
            this.swiftBicCode = swiftBicCode;
            return this;
        }

        public BeneficiaryResponseModel build() {
            // Perform validation or additional logic if needed
            return new BeneficiaryResponseModel(this);
        }
    }
    
}
