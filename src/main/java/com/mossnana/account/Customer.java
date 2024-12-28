package com.mossnana.account;

import java.util.HashSet;
import java.util.Set;

import com.mossnana.account.exception.InvalidFormatEmail;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Customer extends DataPattern {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String firstName;

  private String lastName;

  private String middleName;

  private String email;

  @ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(name = "customer_account", joinColumns = {
      @JoinColumn(name = "customer_id", referencedColumnName = "id")
  }, inverseJoinColumns = {
      @JoinColumn(name = "account_id", referencedColumnName = "id")
  })
  private final Set<Account> accounts = new HashSet<>();

  public Set<Account> getAccounts() {
    return accounts;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  public String getName() {
    String name = "%s".formatted(firstName);
    for (Object subName : new String[] { middleName, lastName }) {
      if (subName == null)
        continue;
      name = "%s %s".formatted(name, subName);
    }
    return name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) throws InvalidFormatEmail {
    if (!this.isValidEmail(email)) {
      throw new InvalidFormatEmail();
    }

    this.email = email;
  }

}
