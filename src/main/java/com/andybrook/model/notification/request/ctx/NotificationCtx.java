package com.andybrook.model.notification.request.ctx;

public class NotificationCtx {

    protected final NotifSetting setting;

    public NotificationCtx(NotifSetting setting) {
        this.setting = setting;
    }

    public NotifSetting getSetting() {
        return setting;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationCtx{");
        sb.append("setting=").append(setting);
        sb.append('}');
        return sb.toString();
    }
}
