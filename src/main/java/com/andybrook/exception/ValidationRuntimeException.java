package com.andybrook.exception;

public abstract class ValidationRuntimeException extends RuntimeException {

    public ValidationRuntimeException() {
    }

    public ValidationRuntimeException(String message) {
        super(message);
    }
}
