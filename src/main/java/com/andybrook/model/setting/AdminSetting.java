package com.andybrook.model.setting;

import com.andybrook.model.notification.NotificationPolicy;

import java.util.Arrays;
import java.util.Objects;

public class AdminSetting {

    private static final int DEFAULT_ORDERS_TO_SHOW_10 = 10;

    private Long id;
    private int ordersNbToShow;
    private String[] emails;
    private NotificationPolicy notificationPolicy;

    public AdminSetting(Long id, String[] email, NotificationPolicy notificationPolicy, int ordersNbToShow) {
        this.id = id;
        this.emails = email;
        this.notificationPolicy = notificationPolicy;
        this.ordersNbToShow = ordersNbToShow > 0 ? ordersNbToShow : DEFAULT_ORDERS_TO_SHOW_10;
    }

    public AdminSetting(AdminSetting other) {
        Objects.requireNonNull(other);
        this.id = other.id;
        this.emails = other.emails;
        this.ordersNbToShow = other.ordersNbToShow;
        this.notificationPolicy = new NotificationPolicy(other.notificationPolicy);
    }

    public static AdminSetting getDefaultAdminSetting() {
        return new AdminSetting(null, new String[0], NotificationPolicy.getDefaultNotificationPolicy(), DEFAULT_ORDERS_TO_SHOW_10);
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

    public int getOrdersNbToShow() {
        return ordersNbToShow;
    }

    public void setOrdersNbToShow(int ordersNbToShow) {
        this.ordersNbToShow = ordersNbToShow;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdminSetting{");
        sb.append("id=").append(id);
        sb.append(", ordersNbToShow=").append(ordersNbToShow);
        sb.append(", emails=").append(Arrays.toString(emails));
        sb.append(", notificationPolicy=").append(notificationPolicy);
        sb.append('}');
        return sb.toString();
    }
}
