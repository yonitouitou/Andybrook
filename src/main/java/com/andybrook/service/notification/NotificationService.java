package com.andybrook.service.notification;

import com.andybrook.enums.NotificationType;
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

import static com.andybrook.enums.NotificationType.ORDER_CLOSED;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void notify(NotificationRequest request) throws OrderNotFound {
        for (NotificationType type : request.getTypes()) {
            publisher.publishEvent(createEvent(type, request.getCtx()));
        }

    }

    private AbstractEvent createEvent(NotificationType type, NotificationCtx ctx) {
        AbstractEvent event;
        switch (type) {
            case ORDER_CLOSED:
                OrderDocumentCtx docCtx = (OrderDocumentCtx) ctx;
                event = new CloseOrderEvent(AggregatedOrder.toAggregatedOrder(docCtx.getOrder()), ctx.getSetting());
                break;
            default:
                throw new UnsupportedOperationException("Unknown NotificationType : " + type);
        }
        return event;
    }
}
