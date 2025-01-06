package com.example.calculator.lv4.operator;

public interface Operation {

    <T extends Number> T operate(T firstNumber, T secondNumber);

}
