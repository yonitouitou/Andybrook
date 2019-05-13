package com.andybrook.api.rest.ctx.notification;

import com.andybrook.enums.NotificationType;
import com.andybrook.util.IdGenerator;

import java.util.List;

public class NotificationRestRequest {

    private long id;
    private NotificationType type;
    private List<String> emails;

    public NotificationRestRequest(NotificationType type) {
        this.id = IdGenerator.generateId();
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public NotificationType getType() {
        return type;
    }

    public List<String> getEmails() {
        return emails;
    }

    public NotificationRestRequest setEmails(List<String> emails) {
        this.emails = emails;
        return this;
    }
}
