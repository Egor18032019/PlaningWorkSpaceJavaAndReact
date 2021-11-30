package com.work.space.exception_handling;

public class TimeOutSQLException extends RuntimeException {

    public TimeOutSQLException(String message) {
        super(message);
    }
}