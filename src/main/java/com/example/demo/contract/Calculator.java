package com.example.demo.contract;

import com.example.demo.exception.CalculatorException;

import java.math.BigDecimal;

public interface Calculator {

    /**
     * Add numbers
     * @param left
     * @param right
     * @return left + right
     * @throws Exception
     */
    BigDecimal add(BigDecimal left, BigDecimal right) throws CalculatorException;

    /**
     * Subtract numbers
     * @param from - number from which we will subtract
     * @param subtractant - number, which will be subtracted
     * @return from - subtractant
     * @throws Exception
     */
    BigDecimal subtract(BigDecimal from, BigDecimal subtractant) throws CalculatorException;

    /**
     * Multiply numbers
     * @param left
     * @param right
     * @return left * right
     * @throws Exception
     */
    BigDecimal multiply(BigDecimal left, BigDecimal right) throws CalculatorException;

    /**
     * Divide numbers exactly
     * @param dividend
     * @param divisor
     * @return dividend / divisor
     * @throws Exception
     */
    BigDecimal divide(BigDecimal dividend, BigDecimal divisor) throws CalculatorException;
}
