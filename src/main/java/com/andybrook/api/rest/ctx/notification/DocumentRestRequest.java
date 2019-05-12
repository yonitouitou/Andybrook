package com.andybrook.api.rest.ctx.notification;

public class DocumentRestRequest extends NotificationRestRequest {

    protected long dateDocument;

    protected DocumentRestRequest() {
        super();
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
