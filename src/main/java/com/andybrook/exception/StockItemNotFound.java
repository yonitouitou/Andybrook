package com.andybrook.exception;

public class StockItemNotFound extends Exception {

    public StockItemNotFound(long id) {
        this(msg(id));
    }
    public StockItemNotFound(String msg) {
        super(msg);
    }

    private static final String msg(long id) {
        return "Stock Item with id " + id + " not found";
    }
}
