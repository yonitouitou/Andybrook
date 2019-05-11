package com.andybrook.service.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.notification.event.ctx.CloseOrderEvent;
import com.andybrook.model.order.Order;
import com.andybrook.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void notifyOrder(long orderId) throws OrderNotFound {
        Order order = orderService.getOrder(orderId);
        notifyOrderClosed(order);
    }

    @Override
    public void notifyOrderClosed(Order order) {
        publisher.publishEvent(new CloseOrderEvent(AggregatedOrder.toAggregatedOrder(order)));
    }
}
