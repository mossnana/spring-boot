package com.mossnana.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mossnana.account.enums.MetaCode;
import com.mossnana.account.exception.InvalidFormatEmail;

import jakarta.validation.Valid;

@RestController
public class AccountController {
  private final AccountService accountService;

  public AccountController(@Autowired AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping("/")
  public EntityResponse<Account> createAccount(@Valid @RequestBody CreateAccountDto body) {
    EntityResponse<Account> response = new EntityResponse<>();
    try {
      Account account = this.accountService.createAccount(body);
      response.setData(account);
      response.setMeta(MetaCode.OK);
      return response;
    } catch (InvalidFormatEmail e) {
      response.setError(e.toString());
      response.setMeta(MetaCode.OK);
      return response;
    } catch (Exception e) {
      response.setMeta(MetaCode.UNKNOWN);
      response.setError(e.toString());
      return response;
    }
  }
}
