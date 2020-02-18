package com.andybrook.model.notification.request;

import com.andybrook.enums.NotificationType;
import com.andybrook.model.notification.request.ctx.DocumentRequest;

public abstract class NotificationRequest {

    private final NotificationType type;
    private final DocumentRequest documentRequest;
    private final boolean isLiveEvent;

    public NotificationRequest(NotificationType type, boolean isLiveEvent, DocumentRequest documentRequest) {
        this.type = type;
        this.isLiveEvent = isLiveEvent;
        this.documentRequest = documentRequest;
    }

    public DocumentRequest getDocumentRequest() {
        return documentRequest;
    }

    public boolean isLiveEvent() {
        return isLiveEvent;
    }

    public NotificationType getType() {
        return type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationRequest{");
        sb.append("documentRequest=").append(documentRequest);
        sb.append(", isLiveEvent=").append(isLiveEvent);
        sb.append('}');
        return sb.toString();
    }
}
