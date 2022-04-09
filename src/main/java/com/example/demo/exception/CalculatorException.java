package com.example.demo.exception;

public class CalculatorException extends Exception{

    public CalculatorException(Throwable cause) {
        super(cause);
    }
    public CalculatorException(String message) {
        super(message);
    }
}
