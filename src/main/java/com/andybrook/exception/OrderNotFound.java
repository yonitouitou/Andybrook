package com.andybrook.exception;

public class OrderNotFound extends ValidationRuntimeException {

    public OrderNotFound(long id) {
        this(msg(id));
    }

    public OrderNotFound(String msg) {
        super(msg);
    }

    private static final String msg(long orderId) {
        return "Order with id " + orderId + " not found";
    }
}
