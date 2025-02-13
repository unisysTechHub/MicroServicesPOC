package com.poc.banking.UserService.kafka;

import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.stereotype.Component;

@Component
public class ListenerInspector {

    private final KafkaListenerEndpointRegistry registry;

    public ListenerInspector(KafkaListenerEndpointRegistry registry) {
        this.registry = registry;
    }

    public void printListenerIds() {
        registry.getListenerContainers().forEach(container -> {
            System.out.println("Listener ID: " + container.getListenerId());
        });
    }
}