package com.andybrook.exception;

public class OrderClosed extends StockReportException {

    public OrderClosed(long id) {
        super("Stock report already closed : " + id);
    }
}
