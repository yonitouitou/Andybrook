package com.andybrook.service.user;

import com.andybrook.model.user.UserSessionsInfo;
import com.andybrook.model.user.UserSessionsInfo.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private SessionRegistry sessionRegistry;

    @Override
    public List<UserSessionsInfo> getLoggedUsers() {
        return sessionRegistry.getAllPrincipals().stream()
                .map(u -> sessionRegistry.getAllSessions(u, false))
                .filter(sessionInfo -> ! sessionInfo.isEmpty())
                .map(this::createUserSessionsInfo)
                .collect(Collectors.toList());
    }

    private UserSessionsInfo createUserSessionsInfo(List<SessionInformation> sessionsInfo) {
        UserSessionsInfo userSessionsInfo = null;
        String username;
        if (! sessionsInfo.isEmpty()) {
            username = ((User) sessionsInfo.get(0).getPrincipal()).getUsername();
            List<SessionInfo> sessionsList = new ArrayList<>(sessionsInfo.size());
            sessionsInfo.forEach(info -> {
                sessionsList.add(new SessionInfo(info.getSessionId(), info.getLastRequest().getTime()));
            });
            userSessionsInfo = new UserSessionsInfo(username, sessionsList);
        }
        return userSessionsInfo;
    }
}
