package com.example.demo.kafka;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConsumerRecordRecoverer;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.util.backoff.FixedBackOff;

import com.example.demo.model.Account;
import com.example.demo.redis.AccountDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
	 private final Log log = LogFactory.getLog(getClass()); 

  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
      Map<String, Object> configProps = new HashMap<>();
      configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
      configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
      configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
      configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, AccountDeserializer.class);
      return new DefaultKafkaConsumerFactory<>(configProps);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
      ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
      factory.setConsumerFactory(consumerFactory());
      return factory;
  }
  @Bean
  public DeadLetterPublishingRecoverer recoverer(KafkaTemplate<String, String> template) {
      return new DeadLetterPublishingRecoverer(template,
              (record, ex) -> new TopicPartition(record.topic() + ".DLT", record.partition()));
  }
  @Bean
  public DefaultErrorHandler errorHandler(KafkaTemplate<String, String> kafkaTemplate) {
      ConsumerRecordRecoverer recoverer = (record, exception) -> {
          log.error("Failed to process record: {}" + record.toString(), exception);
      };

      // Publishes failed records to DLT
      DeadLetterPublishingRecoverer publishingRecoverer = new DeadLetterPublishingRecoverer(
              kafkaTemplate,
              (ConsumerRecord<?, ?> record, Exception e) -> {
                  String deadLetterTopic = record.topic() + ".DLT";
                  log.error("Sending record to DLT: {}", e);
                  return new TopicPartition(deadLetterTopic, record.partition());
              });

      // Retry 3 times with a fixed delay of 2 seconds between attempts
      FixedBackOff backOff = new FixedBackOff(2000L, 3);

      // Attach recoverer and retry strategy to the error handler
      DefaultErrorHandler errorHandler = new DefaultErrorHandler(publishingRecoverer, backOff);
      errorHandler.setCommitRecovered(true); // Commit the offset after sending to DLT
      return errorHandler;
  }

}

