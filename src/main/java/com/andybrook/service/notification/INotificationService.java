package com.andybrook.service.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.StockReport;

public interface INotificationService {

    void notifyOrder(long orderId) throws OrderNotFound;

    void notifyOrderClosed(StockReport report);
}
