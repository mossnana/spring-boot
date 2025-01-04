package com.mossnana.account.exception;

public class InvalidFormatEmailException extends Exception {
  @Override
  public String getMessage() {
    return "invalid format: email";
  }
}
