package com.andybrook.model.notification;

import com.andybrook.enums.NotificationType;
import com.andybrook.model.api.Email;

public class EmailNotification extends Notification {

    private final Email email;
    private final boolean isSentSuccessfully;

    public EmailNotification(Email email, boolean isSentSuccessfully) {
        super(NotificationType.EMAIL);
        this.email = email;
        this.isSentSuccessfully = isSentSuccessfully;
    }

    public Email getEmail() {
        return email;
    }

    public boolean isSentSuccessfully() {
        return isSentSuccessfully;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmailNotification{");
        sb.append("email=").append(email);
        sb.append('}');
        return sb.toString();
    }
}
