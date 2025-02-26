package com.main.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpErrorJson.class)
    public ResponseEntity<Object> handleHttpErrorJson(HttpErrorJson ex) {
        String status = ex.getStatusCode().getReasonPhrase();
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), status);
        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }
}
