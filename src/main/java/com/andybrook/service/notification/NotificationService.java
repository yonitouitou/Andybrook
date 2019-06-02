package com.andybrook.service.notification;

import com.andybrook.enums.NotificationType;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.notification.event.AbstractEvent;
import com.andybrook.model.notification.event.CloseOrderEvent;
import com.andybrook.model.notification.handler.IDocumentHandler;
import com.andybrook.model.notification.request.NotificationRequest;
import com.andybrook.model.notification.request.ctx.NotificationCtx;
import com.andybrook.model.notification.request.ctx.OrderDocumentCtx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;


import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private IDocumentHandlerService documentHandlerService;

    @Override
    public void asyncNotify(NotificationRequest request) throws OrderNotFound {
        for (NotificationType type : request.getTypes()) {
            publisher.publishEvent(createEvent(type, request.getCtx()));
        }
    }

    @Override
    public List<Path> syncNotify(NotificationRequest request) {
        List<Path> resources = new LinkedList<>();
        for (NotificationType type : request.getTypes()) {
            Class<IDocumentHandler> handlerClass = documentHandlerService.getHandler(type);
            IDocumentHandler handler = applicationContext.getBean(handlerClass);
            Path path = handler.generateDocument(request.getCtx());
            resources.add(path);
        }
        return resources;
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
