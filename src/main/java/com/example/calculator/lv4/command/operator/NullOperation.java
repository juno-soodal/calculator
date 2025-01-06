package com.example.calculator.lv4.command.operator;

import com.example.calculator.lv4.exception.calculator.UnSupportedOperatorException;

public class NullOperation implements Operation {

    @Override
    public <T extends Number> T operate(T firstNumber, T secondNumber) {
        throw new UnSupportedOperatorException();
    }
}
