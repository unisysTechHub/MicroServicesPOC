package com.poc.banking.UserService;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.poc.banking.UserService.kafka.AccountTransactionSerializer;
import com.poc.banking.UserService.model.AccountTransactionModel;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, AccountTransactionModel> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, AccountTransactionSerializer.class);
        DefaultKafkaProducerFactory<String, AccountTransactionModel> factory  = new DefaultKafkaProducerFactory<>(configProps);
        factory.addListener(new DefaultKafkaProducerFactory.Listener<>() {
            @Override
            public void producerAdded(String id, Producer<String, AccountTransactionModel> producer) {
                System.out.println("@Ramesh Producer added: " + id);
            }

            @Override
            public void producerRemoved(String id, Producer<String, AccountTransactionModel> producer) {
                System.out.println("@Ramesh Producer removed: " + id);
            }
        });

        return factory;
    }

    @Bean
    public KafkaTemplate<String, AccountTransactionModel> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}