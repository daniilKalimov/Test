package com.example.demo;

import com.example.demo.exception.CalculatorException;
import com.example.demo.wrapper.Wrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.math.BigDecimal;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = {CalculatorException.class})
    public ResponseEntity<Wrapper> handleCalculatorException(CalculatorException ex) {
        return new ResponseEntity<>(new Wrapper(ex, BigDecimal.class), HttpStatus.BAD_REQUEST);
    }
}
