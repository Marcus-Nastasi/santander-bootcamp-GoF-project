package com.santander.gofTest.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handle(Throwable throwable) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(throwable.getMessage());
    }
}



