package com.andybrook.api.rest.ctx.notification;

import com.andybrook.enums.NotificationType;
import com.andybrook.util.IdGenerator;

public class NotificationRestRequest {

    private long id;
    private NotificationType[] notifTypes;

    public NotificationRestRequest(NotificationType[] notifTypes) {
        this.id = IdGenerator.generateId();
    }

    public long getId() {
        return id;
    }

    public NotificationType[] getNotifTypes() {
        return notifTypes;
    }
}
