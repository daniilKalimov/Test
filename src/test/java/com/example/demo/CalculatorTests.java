package com.example.demo;



import com.example.demo.exception.CalculatorException;
import com.example.demo.impl.ImplCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class CalculatorTests {

    @Autowired
    private ImplCalculator calculator;

    int firstNumber = 4;
    int secondNumber = 2;


    @Test
    void addTest() throws CalculatorException {

        Assertions.assertEquals(calculator.add(BigDecimal.valueOf(firstNumber),BigDecimal.valueOf(secondNumber))
                ,BigDecimal.valueOf(6));

    }

    @Test
    public void subtractTest() throws CalculatorException {

        Assertions.assertEquals(calculator.subtract(BigDecimal.valueOf(firstNumber),BigDecimal.valueOf(secondNumber))
                ,BigDecimal.valueOf(2));
    }

    @Test
    public void multiplyTest() throws CalculatorException {

        Assertions.assertEquals(calculator.multiply(BigDecimal.valueOf(firstNumber),BigDecimal.valueOf(secondNumber))
                , BigDecimal.valueOf(8));
    }

    @Test
    public void divideTest() throws CalculatorException {

        Assertions.assertEquals(calculator.divide(BigDecimal.valueOf(firstNumber),BigDecimal.valueOf(secondNumber))
                , BigDecimal.valueOf(2));
    }

}
