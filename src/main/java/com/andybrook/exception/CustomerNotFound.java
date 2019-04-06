package com.andybrook.exception;

public class CustomerNotFound extends ValidationRuntimeException {

    public CustomerNotFound(long id) {
        super("" + id);
    }
}
