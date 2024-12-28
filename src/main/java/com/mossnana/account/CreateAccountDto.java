package com.mossnana.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class CreateAccountDto {
  @NotEmpty
  public String firstName;

  public String middleName;

  @NotEmpty
  public String lastName;

  @Email
  public String email;

  private Integer userId;

  public void setUserId(Integer userId) {
    this.userId = userId;
  }
}
