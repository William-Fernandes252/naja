package com.example.naja.core.exceptions;

public class NajaTargetException extends RuntimeException {
    public NajaTargetException(String message) {
        super(message);
    }

    public NajaTargetException(String message, Throwable cause) {
        super(message, cause);
    }
}
