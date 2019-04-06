package com.andybrook.exception;

public class OrderItemNotFound extends ValidationRuntimeException {

    public OrderItemNotFound(long id) {
        this(msg(id));
    }
    public OrderItemNotFound(String msg) {
        super(msg);
    }

    private static final String msg(long id) {
        return "Order Item with id " + id + " not found";
    }
}
