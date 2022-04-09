package com.example.demo.controllers;


import com.example.demo.contract.Calculator;
import com.example.demo.exception.CalculatorException;
import com.example.demo.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
@RequestMapping("/api/v1/calculator")
@Api(description = "Производит вычислительные операции с двумя числами")
public class CalculatorController {


    private final Calculator calculator;

    public CalculatorController(Calculator calculator){
        this.calculator = calculator;
    }


    @GetMapping("/add")
    @Operation(
            summary = "Сумма",
            description = "Позволяет получить сумму двух чисел"
    )
    public Wrapper<BigDecimal> add(@RequestParam @Parameter(description = "Первое слагаемое") BigDecimal left,
                                   @RequestParam @Parameter(description = "Второе слагаемое") BigDecimal right) throws CalculatorException {
        return new Wrapper<>(calculator.add(left, right));
    }

    @GetMapping("/subtract")
    @Operation(
            summary = "Разность",
            description = "Позволяет получить разность двух чисел"
    )
    public Wrapper<BigDecimal> subtract(@RequestParam @Parameter(description = "Уменьшаемое") BigDecimal from,
                                        @RequestParam @Parameter(description = "Вычитаемое") BigDecimal subtract) throws CalculatorException{
        return new Wrapper<>(calculator.subtract(from, subtract));
    }

    @GetMapping("/multiply")
    @Operation(
            summary = "Произведение",
            description = "Позволяет получить произведение двух чисел"
    )
    public Wrapper<BigDecimal> multiply(@RequestParam @Parameter(description = "Первый множитель") BigDecimal left,
                                        @RequestParam @Parameter(description = "Второй множитель") BigDecimal right) throws CalculatorException{
        return new Wrapper<>(calculator.multiply(left, right));
    }

    @GetMapping("/divide")
    @Operation(
            summary = "Частное",
            description = "Позволяет получить частное двух чисел"
    )
    public Wrapper<BigDecimal> divide(@RequestParam @Parameter(description = "Делимое") BigDecimal dividend,
                                      @RequestParam @Parameter(description = "Делитель") BigDecimal divisor) throws CalculatorException{
        return new Wrapper<>(calculator.divide(dividend, divisor));
    }
}
