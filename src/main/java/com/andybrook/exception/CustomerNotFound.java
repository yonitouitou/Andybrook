package com.andybrook.exception;

public class CustomerNotFound extends RuntimeException {

    public CustomerNotFound(long id) {
        super("" + id);
    }
}
