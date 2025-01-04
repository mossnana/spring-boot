package com.mossnana.common.v1.response;

import java.util.Optional;
import java.util.UUID;

public class ResponseMeta {
    private String code;
    private String desc;
    private String ref;

    public ResponseMeta setCode(ResponseCode responseCode) {
        switch (responseCode) {
            case OK -> {
                code = "2000";
                desc = "Success";
            }
            case NOT_FOUND -> {
                code = "4000";
                desc = "Data not found";
            }
            case UNKNOWN -> {
                code = "5000";
                desc = "Internal server error";
            }
        }
        return this;
    }

    public ResponseMeta setRef(String referenceId) {
        ref = Optional.ofNullable(referenceId).orElseGet(() -> UUID.randomUUID().toString());
        return this;
    }

}
