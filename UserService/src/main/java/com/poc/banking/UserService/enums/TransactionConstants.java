package com.poc.banking.UserService.enums;

public class TransactionConstants {
	 

	    public static enum TransactionStatus {
	        PENDING,
	        COMPLETED,
	        FAILED,
	        CANCELLED;
	    }

	    public static enum CurrencyType {
	        USD,
	        EUR,
	        GBP,
	        INR,
	        JPY;
	    }
	    public static class TransactionType {
	        public static final String INTRA = "INTRA";
	        public static final String INTERNAL = "INTERNAL";
	        public static final String DOMESTIC_ACH = "DOMESTIC_ACH";
	        public static final String DOMESTIC_WIRE = "DomesticWire";
	        public static final String INTERNATIONAL = "INTERNATIONAL";
	    }
}

