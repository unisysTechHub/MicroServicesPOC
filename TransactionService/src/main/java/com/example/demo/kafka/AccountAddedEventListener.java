package com.example.demo.kafka;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.stereotype.Component;

import com.example.demo.model.Account;

@Component
public class AccountAddedEventListener implements ConsumerSeekAware {
	 private final Log log = LogFactory.getLog(getClass()); 
//    @KafkaListener(
//            id = "accountAddedEventsListener",
//            topics = "ACCOUNT_ADDED",
//            groupId = "group_id",
//            containerFactory = "kafkaListenerContainerFactory"
//    )
//    public void saveAccount(Account account) {
//        if (account != null) {
//            log.info("Account consumed: {}"+ account.getAccountId());
//        }
//    }
//
//    @Override
//    public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
//        for (TopicPartition partition : assignments.keySet()) {
//            // Start reading from the very beginning (offset 0)
//            callback.seekToBeginning(partition.topic(), partition.partition());
//            log.info("Seeking to beginning for partition: {}" +  partition.partition());
//        }
//    }
}
