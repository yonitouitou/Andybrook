package com.andybrook.service.notification;

import com.andybrook.model.StockReport;

public interface INotificationService {

    void notifyReportClosed(StockReport report);
}
