package com.example.demo.service;

import com.example.demo.entity.Transaction;
import com.example.demo.model.TransactionModel;
import com.example.demo.model.TransactionStatus;

public class TransactionMapper {
    
    public static TransactionModel toModel(Transaction transaction) {
        if (transaction == null) {
            return null;
        }
        
        TransactionModel model = new TransactionModel();
        model.setTransactionId(String.valueOf(transaction.getId()));
        model.setSenderAccount(Long.valueOf(transaction.getSenderAccount()));
        model.setSenderAccountType(transaction.getSenderAccountType());
        model.setReceiverAccount(Long.valueOf(transaction.getReceiverAccount()));
        model.setReceiverAccountType(transaction.getReceiverAccountType());
        model.setAmount(transaction.getAmount());
        model.setTransactionType(transaction.getTransactionType());
        model.setTransferType(transaction.getTransferType());
        model.setDescription(transaction.getDescription());
        
        return model;
    }
    
    public static Transaction toEntity(TransactionModel model) {
        if (model == null) {
            return null;
        }
        
        Transaction transaction = new Transaction();
        if (model.getTransactionId() != null) {
            transaction.setId(Long.valueOf(model.getTransactionId()));
        }
        transaction.setSenderAccount(String.valueOf(model.getSenderAccount()));
        transaction.setSenderAccountType(model.getSenderAccountType());
        transaction.setReceiverAccount(String.valueOf(model.getReceiverAccount()));
        transaction.setReceiverAccountType(model.getReceiverAccountType());
        transaction.setAmount(model.getAmount());
        transaction.setTransactionType(model.getTransactionType());
        transaction.setTransferType(model.getTransferType());
        transaction.setDescription(model.getDescription());
        
        return transaction;
    }
    public static void updateTransactionStatus(Transaction transaction, TransactionStatus newStatus) {
        if (transaction != null) {
            transaction.setStatus(newStatus);
        }
    }
}
