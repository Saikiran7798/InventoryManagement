package com.Assignment.InventoryManagement.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ItemsExceptionHandler {

    @ExceptionHandler(CustomExceptions.ItemNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleItemNotFoundException(CustomExceptions.ItemNotFoundException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
