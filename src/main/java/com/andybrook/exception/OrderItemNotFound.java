package com.andybrook.exception;

public class OrderItemNotFound extends Exception {

    public OrderItemNotFound(long id) {
        this(msg(id));
    }
    public OrderItemNotFound(String msg) {
        super(msg);
    }

    private static final String msg(long id) {
        return "Stock Item with id " + id + " not found";
    }
}
