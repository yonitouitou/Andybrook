package com.andybrook.model.notification.request;

import com.andybrook.enums.NotificationType;
import com.andybrook.model.notification.request.ctx.NotificationCtx;

public class NotificationRequest {

    private final NotificationType type;
    private final NotificationCtx ctx;

    public NotificationRequest(NotificationType type, NotificationCtx ctx) {
        this.type = type;
        this.ctx = ctx;
    }

    public NotificationType getType() {
        return type;
    }

    public NotificationCtx getCtx() {
        return ctx;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationRequest{");
        sb.append("type=").append(type);
        sb.append(", ctx=").append(ctx);
        sb.append('}');
        return sb.toString();
    }
}
