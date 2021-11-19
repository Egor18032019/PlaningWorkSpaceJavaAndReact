package com.work.space.exception_handling;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}