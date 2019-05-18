package com.andybrook.model.notification.request.ctx;

import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

public final class NotifSetting {

    private final List<String> emails;
    private final ZonedDateTime dateDocument;
    private final boolean isLiveEvent;

    public NotifSetting(boolean isLiveEvent, ZonedDateTime dateDocument, List<String> emails) {
        this.isLiveEvent = isLiveEvent;
        this.dateDocument = dateDocument != null ? dateDocument : ZonedDateTime.now();
        this.emails = emails != null ? emails : new LinkedList<>();
    }

    public ZonedDateTime getDateDocument() {
        return dateDocument;
    }

    public boolean isLiveEvent() {
        return isLiveEvent;
    }

    public List<String> getEmails() {
        return emails;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotifSetting{");
        sb.append("emails=").append(emails);
        sb.append(", dateDocument=").append(dateDocument);
        sb.append(", isLiveEvent=").append(isLiveEvent);
        sb.append('}');
        return sb.toString();
    }
}
