package com.example.hr_management_ship.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class PhoneNumberException extends RuntimeException {
    public PhoneNumberException() {
        super("Your phone number is not valid");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
