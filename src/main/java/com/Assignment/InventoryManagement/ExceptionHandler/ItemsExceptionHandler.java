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

    @ExceptionHandler(CustomExceptions.ItemNotAvailableException.class)
    public ResponseEntity<ExceptionResponse> handleItemNotAvailableException(CustomExceptions.ItemNotAvailableException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomExceptions.EmptyLowCountException.class)
    public ResponseEntity<ExceptionResponse> handleIEmptyLowCountException(CustomExceptions.EmptyLowCountException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomExceptions.ItemMissingFieldException.class)
    public ResponseEntity<ExceptionResponse> ItemMissingFieldException(CustomExceptions.ItemMissingFieldException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
