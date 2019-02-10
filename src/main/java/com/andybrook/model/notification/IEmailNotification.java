package com.andybrook.model.notification;

import com.andybrook.model.api.Email;
import com.andybrook.model.setting.AdminSetting;

public interface IEmailNotification<T> {

    Email createEmail(AdminSetting adminSetting, T object);
}
