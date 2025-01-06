package com.example.calculator.lv2;


import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Double> list = new ArrayList<>();

    public double calculate(String operator, Integer firstNumber, Integer secondNumber) {
        switch (operator) {
            case "+" :
                return firstNumber + secondNumber;
            case "-":
                return  firstNumber - secondNumber;
            case "*":
                return  firstNumber * secondNumber;
            case "/":
                if (isZero(secondNumber)) {
                    return Double.NaN;
                }
                return  (double) firstNumber / secondNumber;
            default:
                return 0;
        }

    }

    private static boolean isZero(Integer secondNumber) {
        return secondNumber == 0;
    }

    public Double removeFirst() {
        if (list.size() == 0) {
            System.out.println("저장 된 값이 없습니다.");
            return null;
        }
        Double remove = list.remove(0);
        System.out.println("삭제 된 값:" + remove);
        return remove;
    }

    public void printAllResult() {
        System.out.println(list);
    }

    public void printResult(Integer firstNumber, Integer secondNumber, String operator, double result) {
        System.out.println(firstNumber + " " + operator + " " + secondNumber + " = "  + result);
    }

    public List<Double> getList() {
        return new ArrayList<>(list);
    }

    public void setList(List<Double> list) {
        this.list = list;
    }
}
