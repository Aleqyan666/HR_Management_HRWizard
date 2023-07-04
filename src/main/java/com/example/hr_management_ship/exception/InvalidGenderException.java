package com.example.hr_management_ship.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class InvalidGenderException extends RuntimeException {
    public InvalidGenderException() {
        super("Only 2 gender do exist");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

