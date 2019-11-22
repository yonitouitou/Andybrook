package com.andybrook.api.rest;

import com.andybrook.manager.user.IUserManager;
import com.andybrook.model.user.UserSessionsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/user")
public class UserController {

    @Autowired
    private IUserManager userManager;

    @GetMapping(path = "/loggedUsers")
    public List<UserSessionsInfo> getLoggedUsers() {
        return userManager.getLoggedUsers();
    }
}
