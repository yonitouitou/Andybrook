package com.andybrook.service.notification;

import com.andybrook.enums.NotificationType;
import com.andybrook.model.notification.handler.IDocumentHandler;

public interface IDocumentHandlerService {

    Class<IDocumentHandler> getHandler(NotificationType type);
}
