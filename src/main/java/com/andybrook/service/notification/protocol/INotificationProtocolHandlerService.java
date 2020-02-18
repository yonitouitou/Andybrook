package com.andybrook.service.notification.protocol;

import com.andybrook.enums.NotificationType;
import com.andybrook.model.notification.handler.protocol.INotificationProtocolHandler;

public interface INotificationProtocolHandlerService {

    INotificationProtocolHandler getHandler(NotificationType type);
}
