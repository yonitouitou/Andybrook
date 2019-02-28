package com.andybrook.api.rest;

import com.andybrook.exception.CustomerNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

public abstract class AbstractController {

    @ExceptionHandler({Exception.class})
    public void handleException(Exception e) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Error handling");
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Exception occurred", e);
    }

    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<?> handleCustomerNotFound(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
