package com.co.izyacademy.exceptions;

public class ExcelLecturaException extends Exception{
    public  ExcelLecturaException(String message) {
        super(message);
    }
    public ExcelLecturaException(String message, Throwable cause) {
        super(message, cause);
    }
}
