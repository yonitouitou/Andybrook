package com.andybrook.api.rest;

import com.andybrook.ApplicationProperties;
import com.andybrook.api.rest.ctx.notification.OrderDocumentRestRequest;
import com.andybrook.enums.NotificationType;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.manager.notification.INotificationManager;
import com.andybrook.manager.order.IOrderManager;
import com.andybrook.model.notification.request.NotificationRequest;
import com.andybrook.model.notification.request.ctx.OrderDocumentCtx;
import com.andybrook.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Collection;
import java.util.List;

import static com.andybrook.util.DateUtil.epochTimeInMillisToZdt;

@RestController
@RequestMapping("v1/notification")
public class NotificationController extends AbstractController {

    private static Logger LOGGER = System.getLogger(OrderController.class.getSimpleName());

    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    private INotificationManager notificationManager;
    @Autowired
    private IOrderManager orderManager;

    @PostMapping(path = "/order-notification")
    public void notify(@RequestBody OrderDocumentRestRequest request) throws OrderNotFound {
        LOGGER.log(Level.INFO, "Notifications request : " + request.toString());
        Order order = orderManager.getOrder(request.getOrderId());
        OrderDocumentCtx ctx = OrderDocumentCtx.builder(false, order)
                .setDateDocument(epochTimeInMillisToZdt(request.getDateDocument(), applicationProperties.getZoneId()))
                .setEmails(request.getEmails())
                .build();
        notificationManager.notify(new NotificationRequest(request.getType(), ctx));
    }

    @GetMapping(path = "/notification-types")
    public NotificationType[] getNotificationTypes() {
        return NotificationType.values();
    }
}
