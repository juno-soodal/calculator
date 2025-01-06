package com.example.calculator.lv4.exception.calculator;

import com.example.calculator.lv4.exception.ErrorMessage;

public class NoCalculationResultException extends CalculatorException {
    public NoCalculationResultException() {
        super(ErrorMessage.NO_CALCULATION_RESULT);

    }public NoCalculationResultException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
