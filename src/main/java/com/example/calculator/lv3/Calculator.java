package com.example.calculator.lv3;


import com.example.calculator.lv3.operator.NoOperation;
import com.example.calculator.lv3.operator.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Calculator {

    private final List<Double> list = new ArrayList<>();

    private Map<OperatorType, Operation> operations;
    private Operation noOperation = new NoOperation();

    public Calculator(Map<OperatorType, Operation> operations) {
        this.operations = operations;
    }

    public double calculate(OperatorType operator, Integer firstNumber, Integer secondNumber) {
        Operation operation = operations.getOrDefault(operator, noOperation);
        try {
            double result = operation.operate(firstNumber, secondNumber);
            addNumber(result);
            return result;
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
            return 0.0;
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
        Double remove = list.remove(0);
        System.out.println("삭제 된 값:" + remove);
        return remove;
    }

    public void printAllResult() {
        System.out.println(list);
    }

    public void printResult(Integer firstNumber, Integer secondNumber, OperatorType operator, double result) {
        System.out.println(firstNumber + " " + operator.getOperatorSymbol() + " " + secondNumber + " = "  + result);
    }
}
