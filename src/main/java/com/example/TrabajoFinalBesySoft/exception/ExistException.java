package com.example.TrabajoFinalBesySoft.exception;

public class ExistException extends RuntimeException{
    public ExistException(String message) {
        super(message);
    }

    public ExistException(String message, Throwable cause) {
        super(message, cause);
    }}

