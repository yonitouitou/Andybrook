package com.andybrook.manager.user;

import com.andybrook.model.user.UserSessionsInfo;
import com.andybrook.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements IUserManager {

    @Autowired
    private IUserService userService;

    @Override
    public List<UserSessionsInfo> getLoggedUsers() {
        return userService.getLoggedUsers();
    }
}
