package com.toyshop.supplierservice.exception;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap; import java.util.Map;

//ResponseEntity<?> means:"I will return any type (Map, String, JSON, etc.) inside a ResponseEntity."


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex) {
        Map<String,String> response=new HashMap<>(); response.put("error",ex.getMessage()); 
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String,String> errors=new HashMap<>(); ex.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(), error.getDefaultMessage())); return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception ex) {
        Map<String,String> response=new HashMap<>(); response.put("error","Something went wrong: "+ex.getMessage()); return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
