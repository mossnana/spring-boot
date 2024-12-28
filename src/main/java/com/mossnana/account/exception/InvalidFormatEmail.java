package com.mossnana.account.exception;

public class InvalidFormatEmail extends Exception {
  @Override
  public String getMessage() {
    return "invalid format: email";
  }
}
