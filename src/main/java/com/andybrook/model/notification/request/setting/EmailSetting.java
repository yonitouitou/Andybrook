package com.andybrook.model.notification.request.setting;

import java.util.Arrays;

public class EmailSetting extends NotifSetting {

    private final String[] emails;

    public EmailSetting(String... emails) {
        this.emails = emails;
    }

    public boolean hasEmails() {
        return emails.length > 0;
    }

    public String[] getEmails() {
        return emails;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmailSetting{");
        sb.append("emails=").append(Arrays.toString(emails));
        sb.append('}');
        return sb.toString();
    }
}
