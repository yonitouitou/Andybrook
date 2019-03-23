package com.andybrook.api.rest;

import com.andybrook.exception.CustomerNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public abstract class AbstractController {

    private static Logger LOGGER = System.getLogger(AbstractController.class.getSimpleName());

    @ExceptionHandler({Exception.class})
    public void handleException(Exception e) {
        LOGGER.log(Level.ERROR, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Error handling", e);
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Exception occurred", e);
    }

    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<?> handleCustomerNotFound(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
