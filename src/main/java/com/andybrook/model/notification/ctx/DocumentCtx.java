package com.andybrook.model.notification.ctx;

public class DocumentCtx {

    private final DocSetting setting;

    public DocumentCtx(DocSetting setting) {
        this.setting = setting;
    }

    public DocSetting getSetting() {
        return setting;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DocumentCtx{");
        sb.append("setting=").append(setting);
        sb.append('}');
        return sb.toString();
    }
}
