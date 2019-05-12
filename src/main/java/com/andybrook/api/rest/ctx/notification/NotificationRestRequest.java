package com.andybrook.api.rest.ctx.notification;

import com.andybrook.util.IdGenerator;

public class NotificationRestRequest {

    private long id;

    public NotificationRestRequest() {
        this.id = IdGenerator.generateId();
    }

    public long getId() {
        return id;
    }
}
