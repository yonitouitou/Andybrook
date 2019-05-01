package com.andybrook.exception;

public class OrderNotFound extends ValidationRuntimeException {

    public OrderNotFound(long id) {
        super(String.valueOf(id));
    }
}
