package com.co.izyacademy.exceptions;

public class UnexpectedRedirectionException extends RuntimeException {
    public UnexpectedRedirectionException(String expectedUrl, String actualUrl) {
        super(String.format("Redirección inesperada. Se esperaba: %s, pero se redirigió a: %s",
                expectedUrl, actualUrl));
    }
}
