package com.example.calculator.lv2.operator;

public class NoOperation implements Operation{
    @Override
    public Double operate(Integer firstNumber, Integer secondNumber) {
        System.out.println("없는 연산자 입니다.");
        return null;
    }
}
