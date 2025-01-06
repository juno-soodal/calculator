package com.example.calculator.lv4.exception.calculator;

import com.example.calculator.lv4.exception.ErrorMessage;

public class UnSupportedOperatorException extends CalculatorException{
    public UnSupportedOperatorException() {
        super(ErrorMessage.UN_SUPPORTED_OPERATOR);
    }public UnSupportedOperatorException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
