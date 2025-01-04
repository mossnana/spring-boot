package com.mossnana.exception;

public class NotFoundException extends Exception {
    public NotFoundException(String entity) {
        super("Entity %s not found".formatted(entity));
    }
}
