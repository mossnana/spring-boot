package com.mossnana.account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataPattern {
  public boolean isValidEmail(String email) {
    Pattern pattern = Pattern.compile("^[\\w-\\.]+@mossnana.com$", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(email);
    return matcher.find();
  }
}
