package com.andybrook.exception;

public class OrderClosed extends ValidationRuntimeException {

    public OrderClosed(long id) {
        super("Stock report already closed : " + id);
    }
}
