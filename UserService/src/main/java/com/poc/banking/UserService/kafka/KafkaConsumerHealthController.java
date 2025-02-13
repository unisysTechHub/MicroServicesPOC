package com.poc.banking.UserService.kafka;

import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class KafkaConsumerHealthController {

private final KafkaListenerEndpointRegistry registry;

public KafkaConsumerHealthController(KafkaListenerEndpointRegistry registry) {
    this.registry = registry;
}

@GetMapping("/health/kafka-consumer")
public Map<String, String> checkConsumerHealth(@RequestParam String listenerId) {
    MessageListenerContainer container = registry.getListenerContainer(listenerId);

    if (container != null && container.isRunning()) {
        return Map.of("status", "UP", "listenerId", listenerId, "message", "Kafka consumer is running");
    } else {
        return Map.of("status", "DOWN", "listenerId", listenerId, "message", "Kafka consumer is stopped");
    }
}


}

