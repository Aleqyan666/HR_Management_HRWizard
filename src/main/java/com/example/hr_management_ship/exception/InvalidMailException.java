package com.example.hr_management_ship.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)

public class InvalidMailException extends RuntimeException {
    public InvalidMailException() {
        super("Please choose valid email");
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
