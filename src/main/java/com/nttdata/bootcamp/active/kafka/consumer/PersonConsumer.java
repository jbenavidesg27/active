package com.nttdata.bootcamp.active.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.bootcamp.active.model.dto.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * Implements Consumer.
 *
 */
public class PersonConsumer {
  
  private static final Logger log = LoggerFactory.getLogger(PersonConsumer.class.getName());
  
  /**
   * Consumer.
   * 
   */
  @KafkaListener(topics = "person-topic", groupId = "group_id")
  public Client consume(String message) throws JsonMappingException, JsonProcessingException {
    log.info("Consuming Message {}", message);
    ObjectMapper mapper = new ObjectMapper();
    Client cliente = mapper.readValue(message, Client.class);    
    return cliente;
    
  }
}
