package com.andybrook.model.notification;

public class NotificationPolicy {

    private Long id;
    private boolean onCloseReport = false;

    public NotificationPolicy() {
        this.id = null;
    }

    public NotificationPolicy(Long id) {
        this.id = id;
    }

    public static NotificationPolicy getDefaultNotificationPolicy() {
        NotificationPolicy policy = new NotificationPolicy();
        policy.setOnCloseReport(false);
        return policy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean onCloseReport() {
        return onCloseReport;
    }

    public void setOnCloseReport(boolean send) {
        onCloseReport = send;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationPolicy{");
        sb.append("onCloseReport=").append(onCloseReport);
        sb.append('}');
        return sb.toString();
    }
}
