package com.example.calculator.lv3.operator;

public interface Operation {

    <T extends Number> T operate(T firstNumber, T secondNumber);

}
