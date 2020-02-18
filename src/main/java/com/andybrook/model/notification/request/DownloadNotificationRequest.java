package com.andybrook.model.notification.request;

import com.andybrook.enums.NotificationType;
import com.andybrook.model.notification.request.ctx.DocumentRequest;

public class DownloadNotificationRequest extends NotificationRequest {

    private boolean withCompression;

    public DownloadNotificationRequest(boolean isLiveEvent, DocumentRequest documentRequest) {
        super(NotificationType.DOWNLOAD, isLiveEvent, documentRequest);
        this.withCompression = documentRequest.getFormats().size() > 1;
    }


    public boolean useCompression() {
        return withCompression;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DownloadNotificationRequest{");
        sb.append("withCompression=").append(withCompression);
        sb.append('}');
        return sb.toString();
    }
}
