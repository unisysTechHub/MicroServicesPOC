package com.example.demo.redis;

import com.example.demo.model.Account;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;

import java.util.Map;

public class AccountDeserializer implements Deserializer<Account> {
	private final Log log = LogFactory.getLog(getClass());
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @Autowired
    DeadLetterPublishingRecoverer  dlt;
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
        	  log.debug("Error deserializing Account object" + e.getLocalizedMessage());
        	  return null;
            //throw new RuntimeException("Error deserializing Account object", e);
        }
    }

    @Override
    public void close() {
    }
}
