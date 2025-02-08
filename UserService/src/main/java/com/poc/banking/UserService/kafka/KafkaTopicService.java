package com.poc.banking.UserService.kafka;

import java.util.Collections;

import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaTopicService {
	
  @Autowired
  private  AdminClient adminClient;
	
	public void deleteTopic(String topicName) {
        adminClient.deleteTopics(Collections.singletonList(topicName));
        System.out.println("Topic deleted: " + topicName);
    }

	public AdminClient getAdminClient() {
		return adminClient;
	}
	
}
