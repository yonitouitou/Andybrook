package com.andybrook.model.notification.request;

import com.andybrook.enums.NotificationType;
import com.andybrook.model.notification.request.ctx.NotificationCtx;

import java.util.List;

public class NotificationRequest {

    private final List<NotificationType> types;
    private final NotificationCtx ctx;

    public NotificationRequest(List<NotificationType> types, NotificationCtx ctx) {
        this.types = types;
        this.ctx = ctx;
    }

    public List<NotificationType> getTypes() {
        return types;
    }

    public NotificationCtx getCtx() {
        return ctx;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationRequest{");
        sb.append("types=").append(types);
        sb.append(", ctx=").append(ctx);
        sb.append('}');
        return sb.toString();
    }
}
