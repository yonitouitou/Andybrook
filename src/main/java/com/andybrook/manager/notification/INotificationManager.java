package com.andybrook.manager.notification;

import com.andybrook.model.StockReport;

public interface INotificationManager {

    void notifyReportClosed(StockReport report);
}
