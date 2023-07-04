package com.example.hr_management_ship.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class InvalidLinkedinException extends RuntimeException {
    public InvalidLinkedinException() {
        super("Please choose valid linkedin account");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
