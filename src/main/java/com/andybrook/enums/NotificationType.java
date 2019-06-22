package com.andybrook.enums;

public enum NotificationType {

    EMAIL(true),
    DOWNLOAD(false);

    private boolean isAsync;

    NotificationType(boolean isAsync) {
        this.isAsync = isAsync;
    }

    public boolean isAsync() {
        return isAsync;
    }
}
