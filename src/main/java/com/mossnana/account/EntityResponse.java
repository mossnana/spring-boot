package com.mossnana.account;

import java.util.ArrayList;
import java.util.List;

import com.mossnana.account.enums.MetaCode;
import com.mossnana.account.models.MetaResponse;

public class EntityResponse<T> {
  private MetaResponse meta = null;
  private T data;
  private final ArrayList<String> errors = new ArrayList<>();

  public void setData(T data) {
    this.data = data;
  }

  public T getData() {
    return this.data;
  }

  public void setMeta(MetaCode meta) {
    this.meta = new MetaResponse();
    this.meta.setCode(meta);
  }

  public void setError(String error) {
    this.errors.add(error);
  }

  public List<String> getErrors() {
    return this.errors;
  }

  public MetaResponse getMeta() {
    return this.meta;
  }
}
