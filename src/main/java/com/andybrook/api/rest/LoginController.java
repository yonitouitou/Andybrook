package com.andybrook.api.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
public class LoginController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("loginSuccess")
    public void loginSuccess() {
        System.err.println("SUCCESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
    }

}
