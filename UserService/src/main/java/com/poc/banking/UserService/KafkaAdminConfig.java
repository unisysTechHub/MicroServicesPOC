package com.poc.banking.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaAdminConfig {
	public static String ACCOUNT_ADDED = "ACCOUNT_ADDED";
	
    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name(ACCOUNT_ADDED)
                .partitions(10)
                .replicas(1)
                .compact()
                .build();
        }
   
    @Bean
    public AdminClient adminClient() {
    	  Properties config = new Properties();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return  AdminClient.create(config);
    }
}
