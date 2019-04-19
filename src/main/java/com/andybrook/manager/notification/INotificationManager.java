package com.andybrook.manager.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.order.Order;

public interface INotificationManager {

    void notifyOrder(long orderId) throws OrderNotFound;

    void notifyOrderClosed(Order report);
}
