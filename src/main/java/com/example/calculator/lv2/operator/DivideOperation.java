package com.example.calculator.lv2.operator;

public class DivideOperation implements Operation{
    @Override
    public Double operate(Integer firstNumber, Integer secondNumber) {
        validate(secondNumber);
        return (double) firstNumber / secondNumber;
    }

    private void validate(Integer secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("나눗셈은 0으로 나눌 수 없습니다.");
        }
    }
}
