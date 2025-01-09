package com.mossnana.account;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
public class AccountController {
  private final AccountService accountService;
  private final AccountEventProducer accountEventProducer;

  public AccountController(@Autowired AccountService accountService, @Autowired AccountEventProducer accountEventProducer) {
    this.accountService = accountService;
    this.accountEventProducer = accountEventProducer;
  }

  @PostMapping("/")
  public ResponseEntity<HashMap<String, Object>> createAccount(@Valid @RequestBody CreateAccountDto body) {
    try {
      Account account = this.accountService.createAccount(body);
      HashMap<String, Object> response = new HashMap<>();
      response.put("id", account.getId());
      response.put("name", account.getName());
      response.put("email", account.getEmail());
      response.put("accountStatus", account.getAccountStatus());
      accountEventProducer.sendOrderEvent(response.toString());
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      return  new ResponseEntity<>(new HashMap<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @KafkaListener(topics = "test", groupId = "test")
  public void handleEventTest(String message) {
    System.out.printf("receive event: %s%n", message);
  }
}
