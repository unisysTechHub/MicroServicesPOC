package com.poc.banking.UserService.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.banking.UserService.model.AccountTransactionModel;

import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class AccountTransactionSerializer implements Serializer<AccountTransactionModel> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, AccountTransactionModel data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing AccountTransactionModel", e);
        }
    }

    @Override
    public void close() {
    }
}
