package com.mossnana.account.exception;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountException extends Exception {
  private final List<Exception> exceptions = new ArrayList<>();

  public void setException(Exception exception) {
    exceptions.add(exception);
  }

  public void setError(Error error) {
    exceptions.add(new Exception(error));
  }

  public boolean isThrowException() {
    return !exceptions.isEmpty();
  }

  @Override
  public String getMessage() {
    StringBuilder msg = new StringBuilder();
    for (Object exception : exceptions) {
      msg.append(exception.toString());
    }
    return "Create account errors: %s".formatted(msg.toString());
  }
}
