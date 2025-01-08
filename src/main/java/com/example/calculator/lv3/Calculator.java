package com.example.calculator.lv3;


import java.util.ArrayList;
import java.util.List;

public class Calculator<T extends Number> {

    private List<T> list = new ArrayList<>();

    public T calculate(OperatorType operator, T firstNumber, T secondNumber) {
        if (firstNumber instanceof Double) {
            return (T) doubleCalculate(operator, firstNumber.doubleValue(), secondNumber.doubleValue());
        }
        return (T) intCalculate(operator, firstNumber.intValue(), secondNumber.intValue());


    }

    private Integer intCalculate(OperatorType operator, int firstNumber, int secondNumber) {
        switch (operator) {
            case PLUS:
                return firstNumber + secondNumber;
            case MINUS:
                return firstNumber - secondNumber;
            case MULTIPLY:
                return firstNumber * secondNumber;
            case DIVIDE:
                return firstNumber / secondNumber;
            default:
                return null;
        }
    }

    private Double doubleCalculate(OperatorType operator, double firstNumber, double secondNumber) {
        switch (operator) {
            case PLUS:
                return firstNumber + secondNumber;
            case MINUS:
                return firstNumber - secondNumber;
            case MULTIPLY:
                return firstNumber * secondNumber;
            case DIVIDE:
                return firstNumber / secondNumber;
            default:
                return null;
        }
    }

    public void addNumber(T number) {
        list.add(number);
    }

    public T removeFirst() {
        if (list.size() == 0) {
            System.out.println("저장 된 값이 없습니다.");
            return null;
        }
        T remove = list.remove(0);
        System.out.println("삭제 된 값:" + remove);
        return remove;
    }

    public List<T> getList() {
        return new ArrayList<>(list);
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void printResult(T firstNumber, T secondNumber, OperatorType operator, T result) {
        System.out.println(firstNumber + " " + operator.getOperatorSymbol() + " " + secondNumber + " = " + result);
    }

    public void findValuesAboveLimit(Number limitValue) {
        List<T> list1 = list.stream().filter((T v) -> v.doubleValue() > limitValue.doubleValue()).toList();
        System.out.println(list1);
    }
}
