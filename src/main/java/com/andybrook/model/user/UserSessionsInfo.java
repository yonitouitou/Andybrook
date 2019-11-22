package com.andybrook.model.user;

import java.util.List;

public class UserSessionsInfo {

    private final String username;
    private final List<SessionInfo> sessionsInfo;

    public UserSessionsInfo(String username, List<SessionInfo> sessionsInfo) {
        this.username = username;
        this.sessionsInfo = sessionsInfo;
    }

    public String getUsername() {
        return username;
    }

    public List<SessionInfo> getSessionsInfo() {
        return sessionsInfo;
    }

    public static final class SessionInfo {

        private final String sessionId;
        private final long lastLoginDatetime;

        public SessionInfo(String sessionId, long lastLoginDatetime) {
            this.sessionId = sessionId;
            this.lastLoginDatetime = lastLoginDatetime;
        }

        public String getSessionId() {
            return sessionId;
        }

        public long getLastLoginDatetime() {
            return lastLoginDatetime;
        }

        @Override
        public String toString() {
            return "LoggedUserInfo{" +
                    "sessionId='" + sessionId + '\'' +
                    ", lastLoginDatetime=" + lastLoginDatetime +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "UserSessionsInfo{" +
                "username='" + username + '\'' +
                ", sessionsInfo=" + sessionsInfo +
                '}';
    }
}
