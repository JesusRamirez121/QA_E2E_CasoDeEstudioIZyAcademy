package com.co.izyacademy.exceptions;

public class EsperaProcessingException extends RuntimeException{
    public EsperaProcessingException(String message, Throwable cause)  {
        super(message, cause);
    }

    public EsperaProcessingException(String message) {
        super(message);
    }

    public EsperaProcessingException(Throwable cause) {
        super(cause);
    }
}
