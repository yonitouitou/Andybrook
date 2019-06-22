package com.andybrook.model.notification.handler;

import com.andybrook.enums.FileFormat;
import com.andybrook.model.api.Email;
import com.andybrook.model.notification.request.ctx.DocumentCtx;
import com.andybrook.model.notification.request.setting.EmailSetting;

import java.nio.file.Path;
import java.util.List;

public interface IDocumentHandler<T> {

    Email generateEmail(EmailSetting setting, DocumentCtx ctx, List<Path> attachments);

    Path generateDocument(FileFormat format, DocumentCtx ctx);
}
