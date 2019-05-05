package com.andybrook.api.rest;

import com.andybrook.exception.*;
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

    @ExceptionHandler(StoreNotFound.class)
    public ResponseEntity<?> handleStoreNotFound(StoreNotFound e) {
        LOGGER.log(Level.WARNING, "Store not found : " + e.getMessage());
        return new ResponseEntity<>("Store not found : " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<?> handleCustomerNotFound(CustomerNotFound e) {
        LOGGER.log(Level.WARNING, "Customer not found : " + e.getMessage());
        return new ResponseEntity<>("Customer not found : " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<?> handleProductNotFound(ProductNotFound e) {
        LOGGER.log(Level.WARNING, "Product not found : " + e.getMessage());
        return new ResponseEntity<>("Product not found : " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductItemNotFree.class)
    public ResponseEntity<?> handleProductNotFound(ProductItemNotFree e) {
        LOGGER.log(Level.WARNING, "Product Item already in an orderItem : " + e.getMessage(), e);
        return new ResponseEntity<>("Product item already in an order.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderItemNotFound.class)
    public ResponseEntity<?> handleOrderItemNotFound(OrderItemNotFound e) {
        LOGGER.log(Level.WARNING, "Order item not found : " + e.getMessage());
        return new ResponseEntity<>("Order item not found : " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderNotFound.class)
    public ResponseEntity<?> handleOrderNotFound(OrderNotFound e) {
        LOGGER.log(Level.WARNING, "Order not found : " + e.getMessage());
        return new ResponseEntity<>("Order not found : " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BarCodeNotFound.class)
    public ResponseEntity<?> handleBarCodeNotFound(BarCodeNotFound e) {
        LOGGER.log(Level.WARNING, "BarCode not found : " + e.getMessage());
        return new ResponseEntity<>("BarCode not found : " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BarCodeNotLinked.class)
    public ResponseEntity<?> handleBarCodeNotFound(BarCodeNotLinked e) {
        LOGGER.log(Level.WARNING, "BarCode not linked to product : " + e.getMessage());
        return new ResponseEntity<>("BarCode not linked to product : " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationRuntimeException.class)
    public ResponseEntity<?> handleValidationException(ValidationRuntimeException e) {
        LOGGER.log(Level.WARNING, "Validation Exception : " + e.getMessage());
        return new ResponseEntity<>("Validation error : " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
