package com.andybrook.model.notification.ctx;

import java.time.ZonedDateTime;

public final class DocSetting {

    private final ZonedDateTime dateDocument;
    private final boolean isLiveEvent;

    public DocSetting(boolean isLiveEvent, ZonedDateTime dateDocument) {
        this.isLiveEvent = isLiveEvent;
        this.dateDocument = dateDocument != null ? dateDocument : ZonedDateTime.now();
    }

    public ZonedDateTime getDateDocument() {
        return dateDocument;
    }

    public boolean isLiveEvent() {
        return isLiveEvent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DocSetting{");
        sb.append("dateDocument=").append(dateDocument);
        sb.append(", isLiveEvent=").append(isLiveEvent);
        sb.append('}');
        return sb.toString();
    }
}
