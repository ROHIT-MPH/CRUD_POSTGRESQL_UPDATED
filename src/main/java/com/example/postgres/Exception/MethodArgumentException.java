package com.example.postgres.Exception;

public class MethodArgumentException extends RuntimeException {
	
    private static final long serialVersionUID = 1L;

    public MethodArgumentException(String message) {
        super(message);

    }
}