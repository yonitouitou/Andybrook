package com.andybrook.config.security;

import org.springframework.http.HttpHeaders;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.Base64Utils;

import javax.servlet.http.HttpServletRequest;

public class HeaderUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        String password = null;
        String headerValue = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (headerValue != null) {
            String[] usernameAndPasswordBase64 = headerValue.split(" ");
            String usernameAndPassword = new String(Base64Utils.decodeFromString(usernameAndPasswordBase64[1]));
            String[] usernameAndPasswordArray = usernameAndPassword.split(":");
            if (usernameAndPasswordArray.length == 2) {
                password = usernameAndPasswordArray[1];
            }
        }
        return password;
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        String username = null;
        String headerValue = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (headerValue != null) {
            String[] usernameAndPasswordBase64 = headerValue.split(" ");
            String usernameAndPassword = new String(Base64Utils.decodeFromString(usernameAndPasswordBase64[1]));
            String[] usernameAndPasswordArray = usernameAndPassword.split(":");
            if (usernameAndPasswordArray.length == 2) {
                username = usernameAndPasswordArray[0];
            }
        }
        return username;
    }
}
