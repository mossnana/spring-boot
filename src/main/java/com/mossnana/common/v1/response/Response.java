package com.mossnana.common.v1.response;

public class Response<T> {
    private ResponseMeta meta;
    private T data;

    public ResponseMeta getMeta() {
        return meta;
    }

    public Response<T> setMeta(ResponseCode code, String referenceId) {
        meta = new ResponseMeta();
        meta.setCode(code).setRef(referenceId);
        return this;
    }

    public T getData() {
        return data;
    }

    public Response<T> setData(T data) {
        return this;
    }

}
