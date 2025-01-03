package com.example.calculator.lv3.operator;

public class MultiplyOperation implements Operation {
    @Override
    public Double operate(Integer firstNumber, Integer secondNumber) {
        return (double) firstNumber * secondNumber;
    }
}
