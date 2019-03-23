package com.andybrook.manager.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.Order;

public interface INotificationManager {

    void notifyOrder(long orderId) throws OrderNotFound;

    void notifyOrderClosed(Order report);
}
