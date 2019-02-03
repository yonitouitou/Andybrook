package com.andybrook.model.notification;

import com.andybrook.model.api.Email;

public interface IEmailNotification<T> {

    Email createEmail(T object);
}
