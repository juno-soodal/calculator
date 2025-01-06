package com.example.calculator.lv4.operator;

public class SubStractOperation implements Operation {

    @Override
    public <T extends Number> T operate(T firstNumber, T secondNumber) {
        if (firstNumber instanceof Double || secondNumber instanceof Double) {
            Double result = firstNumber.doubleValue() - secondNumber.doubleValue();
            return (T) result;
        }
        Integer result = firstNumber.intValue() - secondNumber.intValue();
        return (T) result;
    }
}
