package com.example.calculator.lv4.exception.calculator;

import com.example.calculator.lv4.exception.ErrorMessage;

public class DivideByZeroException extends CalculatorException{
    public DivideByZeroException() {
        super(ErrorMessage.DIVIDE_BY_ZERO);
    }
    public DivideByZeroException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
