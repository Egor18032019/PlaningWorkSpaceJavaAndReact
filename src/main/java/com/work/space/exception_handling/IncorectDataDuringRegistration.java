package com.work.space.exception_handling;

public class IncorectDataDuringRegistration  extends RuntimeException{
    public IncorectDataDuringRegistration(String message) {
        super(message);
    }
}
