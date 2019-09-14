package com.andybrook.api.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
public class LoginController {

    @PostMapping(path = "/authenticate")
    public boolean authenticate() {
        System.out.println("AUTHENTICATIONNNNNNNNNNNNNNNNNNN");
        return true;
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
