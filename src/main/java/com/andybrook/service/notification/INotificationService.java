package com.andybrook.service.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.notification.ctx.DocSetting;
import com.andybrook.model.notification.ctx.OrderDocumentCtx;
import com.andybrook.model.order.Order;

public interface INotificationService {

    void notifyOrder(OrderDocumentCtx ctx) throws OrderNotFound;

    void notifyOrderClosed(Order order, DocSetting setting);
}
