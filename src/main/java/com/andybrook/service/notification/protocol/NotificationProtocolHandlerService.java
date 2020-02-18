package com.andybrook.service.notification.protocol;

import com.andybrook.annotation.EmailOf;
import com.andybrook.annotation.NotificationProtocolHandler;
import com.andybrook.enums.NotificationType;
import com.andybrook.exception.AnnotationNotFound;
import com.andybrook.model.notification.handler.protocol.INotificationProtocolHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.Map;

import javax.annotation.PostConstruct;

@Service
public class NotificationProtocolHandlerService implements INotificationProtocolHandlerService {

    private Map<NotificationType, Class<INotificationProtocolHandler>> handlerClassByNotifType = new EnumMap<>(NotificationType.class);

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    private void init() {
        Map<String, INotificationProtocolHandler> handlerMap = applicationContext.getBeansOfType(INotificationProtocolHandler.class);
        for (INotificationProtocolHandler handler : handlerMap.values()) {
            Class<INotificationProtocolHandler> clazz = (Class<INotificationProtocolHandler>) handler.getClass();
            NotificationProtocolHandler annotation = clazz.getAnnotation(NotificationProtocolHandler.class);
            if (annotation != null) {
                NotificationType type = annotation.value();
                handlerClassByNotifType.put(type, clazz);
            } else {
                throw new AnnotationNotFound(EmailOf.class.getSimpleName());
            }
        }
    }

    @Override
    public INotificationProtocolHandler getHandler(NotificationType type) {
        Class<INotificationProtocolHandler> clazz = handlerClassByNotifType.get(type);
        if (clazz == null) {
            throw new UnsupportedOperationException("Notification type unsupported : " + type);
        }
        return applicationContext.getBean(clazz);
    }
}
