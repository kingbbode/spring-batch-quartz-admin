package com.kingbbode.application.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Not Found.");
    }
}
