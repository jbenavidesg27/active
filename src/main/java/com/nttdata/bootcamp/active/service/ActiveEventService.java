package com.nttdata.bootcamp.active.service;

import com.nttdata.bootcamp.active.events.ActiveCreatedEvent;
import com.nttdata.bootcamp.active.events.Event;
import com.nttdata.bootcamp.active.events.EventType;
import com.nttdata.bootcamp.active.model.Active;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Event Active Service.
 *
 */
@Component
public class ActiveEventService {

  @Autowired
  private KafkaTemplate<String, Event<?>> producer;
    
  @Value("${topic.active.name:customers}")
  private String topicCustomer;
  
  /**
   * Public event.
   */
  public void publish(Active active) {

    ActiveCreatedEvent created = new ActiveCreatedEvent();
    created.setData(active);
    created.setId(UUID.randomUUID().toString());
    created.setType(EventType.CREATED);
    created.setDate(new Date());

    this.producer.send(topicCustomer, created);
  }
}
