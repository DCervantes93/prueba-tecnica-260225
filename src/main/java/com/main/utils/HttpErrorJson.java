package com.main.utils;
import org.springframework.http.HttpStatus;

public class HttpErrorJson extends RuntimeException {

    private final HttpStatus statusCode;
    private final String message;

    public HttpErrorJson(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() { return message; }

}