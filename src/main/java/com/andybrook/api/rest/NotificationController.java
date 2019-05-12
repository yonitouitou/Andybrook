package com.andybrook.api.rest;

import com.andybrook.ApplicationProperties;
import com.andybrook.api.rest.ctx.notification.OrderDocumentRestRequest;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.manager.notification.INotificationManager;
import com.andybrook.model.notification.ctx.OrderDocumentCtx;
import com.andybrook.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.time.ZonedDateTime;

import static com.andybrook.util.DateUtil.epochTimeInMillisToZdt;

@RestController
@RequestMapping("v1/notification")
public class NotificationController extends AbstractController {

    private static Logger LOGGER = System.getLogger(OrderController.class.getSimpleName());

    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    private INotificationManager notificationManager;

    @PostMapping(path = "/order-notification")
    public void notify(@RequestBody OrderDocumentRestRequest request) throws OrderNotFound {
        LOGGER.log(Level.INFO, "Notifications request : " + request.toString());
        OrderDocumentCtx ctx = OrderDocumentCtx.builder(false, request.getOrderId())
                .setDateDocument(epochTimeInMillisToZdt(request.getDateDocument(), applicationProperties.getZoneId()))
                .build();
        notificationManager.notifyOrder(ctx);
    }
}
