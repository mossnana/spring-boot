package com.mossnana.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountEventProducer {

  private static final String TOPIC = "test";
  private final KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  public AccountEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendOrderEvent(String message) {
    kafkaTemplate.send(TOPIC, message);
  }

}
