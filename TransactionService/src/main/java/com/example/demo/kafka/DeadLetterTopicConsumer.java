package com.example.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeadLetterTopicConsumer {

    private static final Logger logger = LoggerFactory.getLogger(DeadLetterTopicConsumer.class);

    @KafkaListener(topics = "ACCOUNT_ADDED.DLT", groupId = "group_id")
    public void listenDLT(ConsumerRecord<String, String> record) {
        logger.warn("DLT Message received: {}", record.value());
        // Implement custom handling (e.g., audit logging, saving to DB, alerting)
    }
}