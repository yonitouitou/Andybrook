package com.andybrook.api.rest;

import com.andybrook.api.rest.ctx.GenericRequestById;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.manager.notification.INotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

@RestController
@RequestMapping("v1/notification")
public class NotificationController extends AbstractController {

    private static Logger LOGGER = System.getLogger(StockReportController.class.getSimpleName());

    @Autowired
    private INotificationManager notificationManager;

    @PostMapping(path = "/report")
    public void notify(@RequestBody GenericRequestById request) throws OrderNotFound {
        LOGGER.log(Level.INFO, "Notifications request for order : " + request.getId());
        notificationManager.notifyOrder(request.getId());
    }
}
