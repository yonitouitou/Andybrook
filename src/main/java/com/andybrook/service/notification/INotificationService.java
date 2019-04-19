package com.andybrook.service.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.order.Order;

public interface INotificationService {

    void notifyOrder(long orderId) throws OrderNotFound;

    void notifyOrderClosed(Order report);
}
