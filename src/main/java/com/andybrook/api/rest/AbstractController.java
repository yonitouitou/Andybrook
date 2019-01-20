package com.andybrook.api.rest;

import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class AbstractController {

    @ExceptionHandler({Exception.class})
    public void handleException(Exception e) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Error handling");
        e.printStackTrace();

    }
}
