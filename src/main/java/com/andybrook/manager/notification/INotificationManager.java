package com.andybrook.manager.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.notification.request.NotificationRequest;
import com.andybrook.model.notification.request.ctx.OrderDocumentCtx;
import com.andybrook.model.order.Order;

public interface INotificationManager {

    void notify(NotificationRequest request) throws OrderNotFound;
}
