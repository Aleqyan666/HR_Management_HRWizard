package com.example.hr_management_ship.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class InvalidCoinRatingException extends RuntimeException {
    public InvalidCoinRatingException() {
        super("Your password has to contain at least 8 characters");
    }

    @Override
    public String getMessage() {
        return super.getMessage();

    }
}