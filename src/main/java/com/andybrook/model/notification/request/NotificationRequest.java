package com.andybrook.model.notification.request;

import com.andybrook.enums.NotificationType;
import com.andybrook.model.notification.request.setting.NotifSetting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NotificationRequest {

    private final Map<NotificationType, NotifSetting> settingMapByNotifType;
    private final DocumentRequest documentRequest;
    private final boolean isLiveEvent;

    public NotificationRequest(boolean isLiveEvent, DocumentRequest documentRequest) {
        this.isLiveEvent = isLiveEvent;
        this.documentRequest = documentRequest;
        settingMapByNotifType = new HashMap<>();
    }

    public NotificationRequest addNotificationType(NotificationType type, NotifSetting setting) {
        settingMapByNotifType.put(type, setting);
        return this;
    }

    public NotifSetting getSetting(NotificationType type) {
        return settingMapByNotifType.get(type);
    }


    public Set<NotificationType> getNotificationTypes() {
        return settingMapByNotifType.keySet();
    }

    public DocumentRequest getDocumentRequest() {
        return documentRequest;
    }

    public boolean isLiveEvent() {
        return isLiveEvent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationRequest{");
        sb.append("settingMapByNotifType=").append(settingMapByNotifType);
        sb.append(", documentRequest=").append(documentRequest);
        sb.append(", isLiveEvent=").append(isLiveEvent);
        sb.append('}');
        return sb.toString();
    }
}
