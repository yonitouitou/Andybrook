package com.andybrook.exception;

public class StockReportNotFound extends Exception {

    public StockReportNotFound(long stockReportId) {
        super("Stock report with id " + stockReportId + " not found");
    }
}
