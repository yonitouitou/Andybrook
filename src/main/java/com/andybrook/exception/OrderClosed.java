package com.andybrook.exception;

public class OrderClosed extends ValidationRuntimeException {

    public OrderClosed(long id) {
        super("Order with id " + id + " already closed.");
    }
}
