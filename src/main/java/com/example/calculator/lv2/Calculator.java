package com.example.calculator.lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Double> list;
    private Double firstNumber;
    private Double secondNumber;
    private String operator;

    public Calculator(List<Double> list) {
        this.list = list;
    }

    public double calculate() {
        switch (operator) {
            case "+" :
                return firstNumber + secondNumber;
            case "-":
                return  firstNumber - secondNumber;
            case "*":
                return  firstNumber * secondNumber;
            case "/":
                return  (double) firstNumber / secondNumber;
            default:
                return 0;
        }
    }

    public void addNumber(double number) {
        list.add(number);
    }

    public Double removeFirst() {
        if (list.size() == 0) {
            System.out.println("저장 된 값이 없습니다.");
            return null;
        }
        return list.remove(0);
    }

    public void printAll() {
        System.out.println(list);
    }

    public Double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
