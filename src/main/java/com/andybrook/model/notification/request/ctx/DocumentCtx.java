package com.andybrook.model.notification.request.ctx;

import java.time.ZonedDateTime;

public class DocumentCtx {

    protected final ZonedDateTime dateDocument;

    public DocumentCtx(ZonedDateTime dateDocument) {
        this.dateDocument = dateDocument;
    }

    public ZonedDateTime getDateDocument() {
        return dateDocument;
    }
}
