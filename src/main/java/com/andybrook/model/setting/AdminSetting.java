package com.andybrook.model.setting;

import com.andybrook.model.notification.NotificationPolicy;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public class AdminSetting {

    private static final int DEFAULT_ITEMS_TO_LOAD_LIMIT_10 = 10;

    private Long id;
    private int loadItemsLimit;
    private String[] emails;
    private Color documentHeaderTableBackgroundColor;
    private Color documentHeaderTableTextColor;
    private NotificationPolicy notificationPolicy;

    public AdminSetting(Long id, String[] email, NotificationPolicy notificationPolicy, int loadItemsLimit,
                        Color documentHeaderTableBackgroundColor, Color documentHeaderTableTextColor) {
        this.id = id;
        this.emails = email;
        this.notificationPolicy = notificationPolicy;
        this.documentHeaderTableBackgroundColor = documentHeaderTableBackgroundColor;
        this.documentHeaderTableTextColor = documentHeaderTableTextColor;
        this.loadItemsLimit = loadItemsLimit > 0 ? loadItemsLimit : DEFAULT_ITEMS_TO_LOAD_LIMIT_10;
    }

    public AdminSetting(AdminSetting other) {
        Objects.requireNonNull(other);
        this.id = other.id;
        this.emails = other.emails;
        this.loadItemsLimit = other.loadItemsLimit;
        this.documentHeaderTableBackgroundColor = other.documentHeaderTableBackgroundColor;
        this.documentHeaderTableTextColor = other.documentHeaderTableTextColor;
        this.notificationPolicy = new NotificationPolicy(other.notificationPolicy);
    }

    public static AdminSetting getDefaultAdminSetting() {
        return new AdminSetting(null, new String[0], NotificationPolicy.getDefaultNotificationPolicy(),
                DEFAULT_ITEMS_TO_LOAD_LIMIT_10, Color.LIGHT_GRAY, Color.BLACK);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    public NotificationPolicy getNotificationPolicy() {
        return notificationPolicy;
    }

    public void setNotificationPolicy(NotificationPolicy notificationPolicy) {
        this.notificationPolicy = notificationPolicy;
    }

    public int getLoadItemsLimit() {
        return loadItemsLimit;
    }

    public void setLoadItemsLimit(int loadItemsLimit) {
        this.loadItemsLimit = loadItemsLimit;
    }

    public Color getDocumentHeaderTableBackgroundColor() {
        return documentHeaderTableBackgroundColor;
    }

    public void setDocumentHeaderTableBackgroundColor(Color documentHeaderTableBackgroundColor) {
        this.documentHeaderTableBackgroundColor = documentHeaderTableBackgroundColor;
    }

    public Color getDocumentHeaderTableTextColor() {
        return documentHeaderTableTextColor;
    }

    public void setDocumentHeaderTableTextColor(Color documentHeaderTableTextColor) {
        this.documentHeaderTableTextColor = documentHeaderTableTextColor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdminSetting{");
        sb.append("id=").append(id);
        sb.append(", loadItemsLimit=").append(loadItemsLimit);
        sb.append(", emails=").append(Arrays.toString(emails));
        sb.append(", documentHeaderTableBackgroundColor=").append(documentHeaderTableBackgroundColor);
        sb.append(", documentHeaderTableTextColor=").append(documentHeaderTableTextColor);
        sb.append(", notificationPolicy=").append(notificationPolicy);
        sb.append('}');
        return sb.toString();
    }
}
