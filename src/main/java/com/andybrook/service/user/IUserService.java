package com.andybrook.service.user;

import com.andybrook.model.user.UserSessionsInfo;

import java.util.List;

public interface IUserService {

    List<UserSessionsInfo> getLoggedUsers();

}
