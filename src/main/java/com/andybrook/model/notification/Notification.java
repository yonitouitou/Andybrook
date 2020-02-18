package com.andybrook.model.notification;

import com.andybrook.enums.NotificationType;
import com.andybrook.util.IdGenerator;
import com.andybrook.util.clock.Clock;

public abstract class Notification {

    private final long id;
    private final long sendTime;
    private final NotificationType type;

    Notification(NotificationType type) {
        this.id = IdGenerator.generateId();
        this.type = type;
        this.sendTime = Clock.millis();
    }

    public long getId() {
        return id;
    }

    public NotificationType getType() {
        return type;
    }

    public long getSendTime() {
        return sendTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Notification{");
        sb.append("id=").append(id);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
