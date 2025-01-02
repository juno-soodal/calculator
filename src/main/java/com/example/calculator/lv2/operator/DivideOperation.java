package com.example.calculator.lv2.operator;

public class DivideOperation implements Operation{
    @Override
    public Double operate(Integer firstNumber, Integer secondNumber) {
        return (double) firstNumber / secondNumber;
    }
}
