package com.andybrook.exception;

public class StockReportClosed extends StockReportException {

    public StockReportClosed(long id) {
        super("Stock report already closed : " + id);
    }
}
