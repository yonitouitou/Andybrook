package com.andybrook.model.notification;

import com.andybrook.model.api.Email;
import com.andybrook.model.notification.request.ctx.DocumentCtx;
import com.andybrook.model.notification.request.setting.EmailSetting;
import com.andybrook.model.notification.request.setting.NotifSetting;

import java.nio.file.Path;
import java.util.List;

public interface IEmailNotification<T> {

    Email createEmail(EmailSetting setting, DocumentCtx docCtx, List<Path> attachments);
}
