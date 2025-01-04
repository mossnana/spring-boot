package com.mossnana.account.exception;

public class NotFoundAccountException extends Exception {
    int accountId;

    public NotFoundAccountException(int accountId) {
        super();
        this.accountId = accountId;
    }

    @Override
    public String getMessage() {
        return "Account not found for id: %s".formatted(this.accountId);
    }
}
