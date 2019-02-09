package com.andybrook.model.request;

import com.andybrook.model.notification.NotificationPolicy;
import com.andybrook.model.setting.AdminSetting;

public class UpdateAdminSettingRequest {

    private Long id;
    private String email;
    private boolean notifyOnCloseReport;

    UpdateAdminSettingRequest() {
    }

    public AdminSetting toAdminSetting() {
        NotificationPolicy policy = new NotificationPolicy();
        policy.setOnCloseReport(notifyOnCloseReport);
        return new AdminSetting(id, email, policy);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    boolean isNotifyOnCloseReport() {
        return notifyOnCloseReport;
    }

    void setNotifyOnCloseReport(boolean notifyOnCloseReport) {
        this.notifyOnCloseReport = notifyOnCloseReport;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UpdateAdminSettingRequest{");
        sb.append("email='").append(email).append('\'');
        sb.append(", notifyOnCloseReport=").append(notifyOnCloseReport);
        sb.append('}');
        return sb.toString();
    }
}
