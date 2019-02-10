package com.andybrook.model.request;

import com.andybrook.model.notification.NotificationPolicy;
import com.andybrook.model.setting.AdminSetting;

import java.util.Arrays;

public class UpdateAdminSettingRequest {

    private Long id;
    private String[] emails;
    private boolean notifyOnCloseReport;

    UpdateAdminSettingRequest() {
    }

    public AdminSetting toAdminSetting() {
        NotificationPolicy policy = new NotificationPolicy();
        policy.setOnCloseReport(notifyOnCloseReport);
        return new AdminSetting(id, emails, policy);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    String[] getEmails() {
        return emails;
    }

    void setEmails(String[] emails) {
        this.emails = emails;
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
        sb.append("email='").append(Arrays.toString(emails)).append('\'');
        sb.append(", notifyOnCloseReport=").append(notifyOnCloseReport);
        sb.append('}');
        return sb.toString();
    }
}
