package com.andybrook.model.notification.event.ctx;

import com.andybrook.model.StockReport;

public class CloseReportEvent {

    private final StockReport report;

    public CloseReportEvent(StockReport report) {
        this.report = report;
    }

    public StockReport getReport() {
        return report;
    }
}
