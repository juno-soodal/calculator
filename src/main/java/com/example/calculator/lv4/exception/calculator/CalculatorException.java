package com.example.calculator.lv4.exception.calculator;

import com.example.calculator.lv4.exception.ErrorMessage;

public class CalculatorException extends RuntimeException{

    public CalculatorException(ErrorMessage errorMessage) {
        super(errorMessage.getDefaultMessage());
    }

}
