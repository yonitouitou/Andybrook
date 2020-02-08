package com.andybrook.manager.event;

import com.andybrook.ApplicationProperties;
import com.andybrook.enums.DocType;
import com.andybrook.enums.NotificationType;
import com.andybrook.manager.notification.INotificationManager;
import com.andybrook.manager.order.IOrderManager;
import com.andybrook.manager.setting.IAdminSettingManager;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.notification.event.OrderClosedEvent;
import com.andybrook.model.notification.request.DocumentRequest;
import com.andybrook.model.notification.request.NotificationRequest;
import com.andybrook.model.notification.request.ctx.OrderDocumentCtx;
import com.andybrook.model.notification.request.setting.EmailSetting;
import com.andybrook.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class OrderClosedEventManager implements ICloseOrderEventManager {

    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    private IAdminSettingManager adminSettingManager;
    @Autowired
    private INotificationManager notificationManager;
    @Autowired
    private IOrderManager orderManager;

    @Override
    @EventListener
    public void handleEvent(OrderClosedEvent event) {
        if (adminSettingManager.shouldNotifyOnCloseOrder()) {
            notify(event.getOrder());
        }
    }

    private void notify(Order order) {
        AggregatedOrder aggregatedOrder = orderManager.aggregate(order);
        OrderDocumentCtx ctx = OrderDocumentCtx.builder(true, order, aggregatedOrder)
                .setDateDocument(ZonedDateTime.now(applicationProperties.getZoneId()))
                .build();
        DocumentRequest documentRequest = new DocumentRequest(DocType.ORDER_FORM, ctx, DocType.ORDER_FORM.getSupportedFormat());
        NotificationRequest request = new NotificationRequest(true, documentRequest);
        request.addNotificationType(NotificationType.EMAIL, new EmailSetting(adminSettingManager.getNotificationEmails()));
        notificationManager.notify(request);
    }
}
