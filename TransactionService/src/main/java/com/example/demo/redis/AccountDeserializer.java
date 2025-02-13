package com.example.demo.redis;

import com.example.demo.model.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import java.util.Map;

public class AccountDeserializer implements Deserializer<Account> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public Account deserialize(String topic, byte[] data) {
    	if (data == null) {
            System.out.println("Received null data for topic: " + topic);
            return null;
        }
        try {
            return objectMapper.readValue(data, Account.class);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing Account object", e);
        }
    }

    @Override
    public void close() {
    }
}
