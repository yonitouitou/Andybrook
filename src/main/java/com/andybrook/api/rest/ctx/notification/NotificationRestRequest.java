package com.andybrook.api.rest.ctx.notification;

import com.andybrook.enums.NotificationType;
import com.andybrook.util.IdGenerator;

import java.util.List;

public class NotificationRestRequest {

    private long id;
    private List<NotificationType> types;
    private List<String> emails;

    public NotificationRestRequest(List<NotificationType> types) {
        this.id = IdGenerator.generateId();
        this.types = types;
    }

    public long getId() {
        return id;
    }

    public List<NotificationType> getTypes() {
        return types;
    }

    public List<String> getEmails() {
        return emails;
    }

    public NotificationRestRequest setEmails(List<String> emails) {
        this.emails = emails;
        return this;
    }
}
