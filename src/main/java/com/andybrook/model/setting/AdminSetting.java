package com.andybrook.model.setting;

public class AdminSetting {

    long id;
    private String email;
    private boolean notifyOnCloseReport;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isNotifyOnCloseReport() {
        return notifyOnCloseReport;
    }

    public void setNotifyOnCloseReport(boolean notifyOnCloseReport) {
        this.notifyOnCloseReport = notifyOnCloseReport;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdminSetting{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", notifyOnCloseReport=").append(notifyOnCloseReport);
        sb.append('}');
        return sb.toString();
    }
}
