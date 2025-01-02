package com.example.calculator.lv2.operator;

public class AddOperation implements Operation {
    @Override
    public Double operate(Integer firstNumber, Integer secondNumber) {
        return (double) firstNumber + secondNumber;
    }
}
