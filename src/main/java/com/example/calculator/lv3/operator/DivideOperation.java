package com.example.calculator.lv3.operator;

public class DivideOperation implements Operation{

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
            throw new ArithmeticException("나눗셈은 0으로 나눌 수 없습니다.");
        }
    }

}
