package com.andybrook.manager.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.notification.ctx.OrderDocumentCtx;
import com.andybrook.model.order.Order;

public interface INotificationManager {

    void notifyOrder(OrderDocumentCtx ctx) throws OrderNotFound;

    void notifyOrderClosed(Order order);
}
