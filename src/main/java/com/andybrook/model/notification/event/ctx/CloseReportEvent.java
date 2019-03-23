package com.andybrook.model.notification.event.ctx;

import com.andybrook.model.Order;

public class CloseReportEvent {

    private final Order report;

    public CloseReportEvent(Order report) {
        this.report = report;
    }

    public Order getReport() {
        return report;
    }
}
