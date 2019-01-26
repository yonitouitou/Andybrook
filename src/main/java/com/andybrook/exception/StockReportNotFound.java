package com.andybrook.exception;

public class StockReportNotFound extends StockReportException {

    public StockReportNotFound(long stockReportId) {
        super("Stock report with id " + stockReportId + " not found");
    }
}
