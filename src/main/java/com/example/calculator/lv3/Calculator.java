package com.example.calculator.lv3;


import com.example.calculator.lv3.operator.NoOperation;
import com.example.calculator.lv3.operator.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Calculator<T extends Number> {

    private final List<T> list = new ArrayList<>();

    private Map<OperatorType, Operation> operations;
    private Operation noOperation = new NoOperation();

    public Calculator(Map<OperatorType, Operation> operations) {
        this.operations = operations;
    }

    public T calculate(OperatorType operator, T firstNumber, T secondNumber) {
        Operation operation = operations.getOrDefault(operator, noOperation);
        try {
            return operation.operate(firstNumber, secondNumber);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
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

    public void printAllResult() {
        System.out.println(list);
    }

    public void printResult(T firstNumber, T secondNumber, OperatorType operator, T result) {
        System.out.println(firstNumber + " " + operator.getOperatorSymbol() + " " + secondNumber + " = "  + result);
    }

    public void findValuesAboveLimit(Number limitValue) {
        List<T> list1 = list.stream().filter((T v) -> v.doubleValue() > limitValue.doubleValue()).toList();
        System.out.println(list1);
    }
}
