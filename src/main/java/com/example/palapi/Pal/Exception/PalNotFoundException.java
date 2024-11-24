package com.example.palapi.Pal.Exception;

@SuppressWarnings("serial")
public class PalNotFoundException extends RuntimeException {

    public PalNotFoundException(String message) {
        super(message);
    }

    public PalNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}