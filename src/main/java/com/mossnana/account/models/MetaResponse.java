package com.mossnana.account.models;

import com.mossnana.account.enums.MetaCode;

public class MetaResponse {
  private String code;
  private String desc;

  public void setCode(MetaCode code) {
    switch (code) {
      case MetaCode.OK -> {
        this.code = "2000";
        this.desc = "OK";
      }
      case MetaCode.NOT_FOUND -> {
        this.code = "4040";
        this.desc = "Not found any data";
      }
      case MetaCode.UNKNOWN -> {
        this.code = "5000";
        this.desc = "Unknown error";
      }
    }
  }

  public String getCode() {
    return this.code;
  }

  public String getDesc() {
    return this.desc;
  }

}
