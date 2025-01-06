package com.example.calculator.lv4.model;


import com.example.calculator.lv4.service.OperatorType;
import com.example.calculator.lv4.exception.calculator.NoCalculationResultException;
import com.example.calculator.lv4.command.operator.Operation;

import java.util.ArrayList;
import java.util.List;

public class Calculator<T extends Number> {

    private final List<T> list = new ArrayList<>();
    private final OperationManager operationManager;

    public Calculator(OperationManager calculatorManager) {
        this.operationManager = calculatorManager;
    }

    public T calculate(OperatorType operatorType, T firstNumber, T secondNumber) {
        Operation operation = operationManager.getOperation(operatorType);
        return operation.operate(firstNumber, secondNumber);
    }

    public void addNumber(T number) {
        list.add(number);
    }

    public T removeFirst() {
        if (list.size() == 0) {
            throw new NoCalculationResultException();
        }
        T remove = list.remove(0);
        System.out.println("삭제 된 값:" + remove);
        return remove;
    }

    public void printResult(T firstNumber, T secondNumber, OperatorType operator, T result) {
        System.out.println(firstNumber + " " + operator.getOperatorSymbol() + " " + secondNumber + " = "  + result);
    }

    public void findValuesAboveLimit(Number limitValue) {
        List<T> list1 = list.stream().filter((T v) -> v.doubleValue() > limitValue.doubleValue()).toList();
        System.out.println(list1);
    }

    public void display() {
        System.out.println("현재 저장 된 값:" + list);
    }
}
