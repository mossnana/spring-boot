package com.mossnana.account;

import com.mossnana.account.constant.AccountStatus;
import jakarta.persistence.*;

@Entity
public class Account {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String name;

  private String email;

  private AccountStatus accountStatus;

  private String userId;

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) { this.id = id; }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isConfirm() {
    return accountStatus == AccountStatus.PENDING;
  }
  public AccountStatus getAccountStatus() { return accountStatus; }
  public void setAccountStatus(AccountStatus status) {
    accountStatus = status;
  }

  public String getUserId() { return userId; };
  public void setUserId(String userId) {
    if (this.userId == null) {
      this.userId = userId;
    }
  }

}
