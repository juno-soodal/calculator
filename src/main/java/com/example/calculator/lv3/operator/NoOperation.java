package com.example.calculator.lv3.operator;

public class NoOperation implements Operation{

    @Override
    public <T extends Number> T operate(T firstNumber, T secondNumber) {
        throw new IllegalArgumentException("현재 없는 연산기호 입니다.");
    }
}
