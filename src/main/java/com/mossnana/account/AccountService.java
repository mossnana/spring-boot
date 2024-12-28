package com.mossnana.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mossnana.account.exception.CreateAccountException;
import com.mossnana.account.exception.InvalidFormatEmail;

import jakarta.transaction.Transactional;

@Service
public class AccountService {
  private final AccountRepository accountRepository;
  private final CustomerRepository customerRepository;

  public AccountService(@Autowired AccountRepository accountRepository, @Autowired CustomerRepository customerRepository) {
    this.accountRepository = accountRepository;
    this.customerRepository = customerRepository;
  }

  @Transactional
  public Account createAccount(CreateAccountDto dao) throws InvalidFormatEmail {
    CreateAccountException createAccountException = new CreateAccountException();
    Customer customer = new Customer();
    customer.setName(dao.firstName, "", dao.lastName);

    try {
      customer.setEmail(dao.email);
    } catch (InvalidFormatEmail e) {
      createAccountException.setException(e);
      throw e;
    }

    Account firstAccount = new Account();
    firstAccount.setEmail(customer.getEmail());
    firstAccount.setName(customer.getName());

    customer = customerRepository.save(customer);
    firstAccount.setCustomer(customer);
    firstAccount = accountRepository.save(firstAccount);
    
    return firstAccount;
  }
}
