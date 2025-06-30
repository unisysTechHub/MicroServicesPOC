package com.poc.banking.UserService.transfer.service;

public class BeneficiaryPropertiesNottFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BeneficiaryPropertiesNottFoundException(String message) {
        super(message);
    }
}
