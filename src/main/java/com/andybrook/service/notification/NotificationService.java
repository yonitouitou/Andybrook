package com.andybrook.service.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.notification.event.AbstractEvent;
import com.andybrook.model.notification.event.CloseOrderEvent;
import com.andybrook.model.notification.request.NotificationRequest;
import com.andybrook.model.notification.request.ctx.NotifSetting;
import com.andybrook.model.notification.request.ctx.NotificationCtx;
import com.andybrook.model.notification.request.ctx.OrderDocumentCtx;
import com.andybrook.model.order.Order;
import com.andybrook.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void notify(NotificationRequest request) throws OrderNotFound {
        publisher.publishEvent(createEvent(request));
    }

    private AbstractEvent createEvent(NotificationRequest request) {
        AbstractEvent event;
        NotificationCtx ctx = request.getCtx();
        switch (request.getType()) {
            case ORDER_CLOSED:
                OrderDocumentCtx docCtx = (OrderDocumentCtx) request.getCtx();
                event = new CloseOrderEvent(AggregatedOrder.toAggregatedOrder(docCtx.getOrder()), ctx.getSetting());
                break;
            default:
                throw new UnsupportedOperationException("Unknown NotificationType : " + request.getType());
        }
        return event;
    }
}
