package com.kk.studentjpql.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentException.class)
    public ResponseEntity<String> handle(StudentException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
