package com.mossnana.account;

import com.mossnana.account.exception.NotFoundAccountException;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.mossnana.account.exception.CreateAccountException;
import com.mossnana.account.exception.InvalidFormatEmailException;

import jakarta.transaction.Transactional;

import java.util.Optional;

@Service
public class AccountService {
  private final AccountRepository accountRepository;
  private final CustomerRepository customerRepository;

  public AccountService(@Autowired AccountRepository accountRepository, @Autowired CustomerRepository customerRepository) {
    this.accountRepository = accountRepository;
    this.customerRepository = customerRepository;
  }

  @Transactional
  public Account createAccount(CreateAccountDto dao) throws CreateAccountException {
    CreateAccountException createAccountException = new CreateAccountException();
    Customer customer = new Customer();
    customer.setName(dao.firstName, "", dao.lastName);
    try {
      customer.setEmail(dao.email);
    } catch (InvalidFormatEmailException error) {
      createAccountException.setException(error);
      throw createAccountException;
    }
    customer = customerRepository.save(customer);

    Account firstAccount = new Account();
    firstAccount.setEmail(customer.getEmail());
    firstAccount.setName(customer.getName());
    firstAccount.setCustomer(customer);

    try {
      firstAccount = accountRepository.save(firstAccount);
    } catch (IllegalAccessError e) {
      createAccountException.setError(e);
      throw createAccountException;
    } catch (OptimisticLockingFailureException e) {
      createAccountException.setException(e);
      throw createAccountException;
    }

    customer.setAccounts(firstAccount);

    try {
      customerRepository.save(customer);
    } catch (IllegalAccessError e) {
      createAccountException.setError(e);
      throw createAccountException;
    } catch (OptimisticLockingFailureException e) {
      createAccountException.setException(e);
      throw createAccountException;
    }

    return firstAccount;
  }

  public Account getAccountById(int id) throws NotFoundAccountException {
    Optional<Account> account = accountRepository.findById(id);
    if (account.isEmpty()) {
      throw new NotFoundAccountException(id);
    }
    return account.get();
  }
}
