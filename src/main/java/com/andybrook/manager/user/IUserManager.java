package com.andybrook.manager.user;

import com.andybrook.model.user.UserSessionsInfo;

import java.util.List;

public interface IUserManager {

    List<UserSessionsInfo> getLoggedUsers();
}
