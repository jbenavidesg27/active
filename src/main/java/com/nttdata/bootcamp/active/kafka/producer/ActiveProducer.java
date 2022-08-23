package com.nttdata.bootcamp.active.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Message Producer.
 *
 */
@Component
public class ActiveProducer {
  private static final Logger log = LoggerFactory.getLogger(ActiveProducer.class.getName());

  private final KafkaTemplate<String, String> kafkaTemplate;

  public ActiveProducer(@Qualifier("kafkaStringTemplate") KafkaTemplate<String, 
      String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(String message) {
    log.info("Producing message {}", message);
    this.kafkaTemplate.send("active-topic", message);
  }

}
