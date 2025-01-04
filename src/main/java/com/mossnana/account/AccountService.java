package com.mossnana.account;

import com.mossnana.account.constant.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class AccountService {
  private final AccountRepository accountRepository;

  public AccountService(@Autowired AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Transactional
  public Account createAccount(CreateAccountDto dto) {
    Account firstAccount = new Account();
    firstAccount.setEmail(dto.email);
    firstAccount.setName(dto.getName());
    firstAccount.setUserId(dto.userId);
    firstAccount.setAccountStatus(AccountStatus.PENDING);

    firstAccount = accountRepository.save(firstAccount);

    return firstAccount;
  }

}
