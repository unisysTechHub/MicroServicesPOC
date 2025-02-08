package com.example.demo.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TransactionIDGenerator {
    public static void main(String[] args) {
        String transactionId = generateTransactionId();
        System.out.println("Transaction ID: " + transactionId);
    }

    public static String generateTransactionId() {
        // Format: YYYYMMDD-HHMMSS
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String dateTime = sdf.format(new Date());
        
        // Add a random 6-character alphanumeric string for uniqueness
        String randomPart = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        
        return "TXN-" + dateTime + "-" + randomPart;
    }
}
