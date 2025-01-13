package com.devConenct.user_service.domain.exception;

public class EmailAlreadyTakenException extends RuntimeException {
    public EmailAlreadyTakenException(String email) {
        super("This email is already taken: " + email);
    }
}