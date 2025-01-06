package com.example.calculator.lv4.operator;

import com.example.calculator.lv4.exception.calculator.DivideByZeroException;

public class DivideOperation implements Operation {

    @Override
    public <T extends Number> T operate(T firstNumber, T secondNumber) {
        validate(secondNumber);
        if (firstNumber instanceof Double || secondNumber instanceof Double) {
            Double result = firstNumber.doubleValue() / secondNumber.doubleValue();
            return (T) result;
        }
        Integer result = firstNumber.intValue() / secondNumber.intValue();
        return (T) result;
    }

    private <T extends Number> void validate(T secondNumber) {
        if (secondNumber.doubleValue() == 0) {
            throw new DivideByZeroException();
        }
    }

}
