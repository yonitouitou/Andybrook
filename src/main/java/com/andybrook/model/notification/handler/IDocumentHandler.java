package com.andybrook.model.notification.handler;

import com.andybrook.model.notification.request.ctx.NotificationCtx;

import java.nio.file.Path;

public interface IDocumentHandler {

    Path generateDocument(NotificationCtx ctx);
}
