package com.andybrook.service.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.StockReport;
import com.andybrook.model.notification.event.ctx.CloseReportEvent;
import com.andybrook.service.stock.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void notifyOrder(long orderId) throws OrderNotFound {
        StockReport order = orderService.getStockReport(orderId);
        notifyOrderClosed(order);
    }

    @Override
    public void notifyOrderClosed(StockReport order) {
        publisher.publishEvent(new CloseReportEvent(order));
    }
}
