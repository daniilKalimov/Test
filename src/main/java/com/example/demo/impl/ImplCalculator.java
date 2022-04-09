package com.example.demo.impl;

import com.example.demo.exception.CalculatorException;
import com.example.demo.contract.Calculator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ImplCalculator implements Calculator {

    @Override
    public BigDecimal add(BigDecimal left, BigDecimal right) throws CalculatorException {
        try {
            return left.add(right);
        } catch(Exception e) {
            throw new CalculatorException(e);
        }
    }

    @Override
    public BigDecimal subtract(BigDecimal from, BigDecimal subtractant) throws CalculatorException {
        try {
            return from.subtract(subtractant);
        } catch(Exception e) {
            throw new CalculatorException(e);
        }
    }

    @Override
    public BigDecimal multiply(BigDecimal left, BigDecimal right) throws CalculatorException {
        try {
            return left.multiply(right);
        } catch(Exception e) {
            throw new CalculatorException(e);
        }
    }

    @Override
    public BigDecimal divide(BigDecimal dividend, BigDecimal divisor) throws CalculatorException {
        try {
            return dividend.divide(divisor);
        } catch(Exception e) {
            throw new CalculatorException(e);
        }
    }
}
