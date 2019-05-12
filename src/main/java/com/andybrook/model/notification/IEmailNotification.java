package com.andybrook.model.notification;

import com.andybrook.model.api.Email;
import com.andybrook.model.setting.AdminSetting;

import java.nio.file.Path;
import java.util.List;

public interface IEmailNotification<T> {

    Email createEmail(AdminSetting adminSetting, T object, List<Path> attachments);
}
