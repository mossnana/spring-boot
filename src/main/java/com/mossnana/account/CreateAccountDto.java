package com.mossnana.account;

import jakarta.validation.constraints.*;

public class CreateAccountDto {
  @NotEmpty
  public String firstName;

  @NotEmpty
  public String lastName;

  @NotEmpty
  public String userId;

  @Email
  public String email;

  public String getName() {
    return "%s %s".formatted(this.firstName, this.lastName);
  }
}
