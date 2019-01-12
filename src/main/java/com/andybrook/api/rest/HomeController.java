package com.andybrook.api.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController extends AbstractController {

    @PostMapping(path = "/home")
    public String home() {
        return "Hello !";
    }
}
