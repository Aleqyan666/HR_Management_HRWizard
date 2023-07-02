package com.example.hr_management_ship.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class InvalidEmployeeLevelException extends RuntimeException {
    public InvalidEmployeeLevelException() {
        super("Please choose valid name");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
