package com.andybrook.api.rest.ctx.notification;

import com.andybrook.enums.NotificationType;

public class DocumentRestRequest extends NotificationRestRequest {

    protected long dateDocument;

    protected DocumentRestRequest(NotificationType type) {
        super(type);
    }

    public long getDateDocument() {
        return dateDocument;
    }

    public void setDateDocument(long dateDocument) {
        this.dateDocument = dateDocument;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DocumentRequest{");
        sb.append("dateDocument=").append(dateDocument);
        sb.append('}');
        return sb.toString();
    }
}
