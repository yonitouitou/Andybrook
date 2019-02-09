package com.andybrook.model.setting;

import com.andybrook.model.notification.NotificationPolicy;

import java.util.Objects;

public class AdminSetting {

    private Long id;
    private String email;
    private NotificationPolicy notificationPolicy;

    public AdminSetting(Long id, String email, NotificationPolicy notificationPolicy) {
        this.id = id;
        this.email = email;
        this.notificationPolicy = notificationPolicy;
    }

    public AdminSetting(AdminSetting other) {
        Objects.requireNonNull(other);
        this.id = other.id;
        this.email = other.email;
        this.notificationPolicy = new NotificationPolicy(other.notificationPolicy);
    }

    public static AdminSetting getDefaultAdminSetting() {
        return new AdminSetting(null, null, NotificationPolicy.getDefaultNotificationPolicy());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NotificationPolicy getNotificationPolicy() {
        return notificationPolicy;
    }

    public void setNotificationPolicy(NotificationPolicy notificationPolicy) {
        this.notificationPolicy = notificationPolicy;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdminSetting{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", notificationPolicy=").append(notificationPolicy);
        sb.append('}');
        return sb.toString();
    }
}
