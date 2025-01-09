package com.example.calculator.lv4.service;

import com.example.calculator.lv4.exception.calculator.UnSupportedOperatorException;

import java.util.Arrays;

public enum OperatorType {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private final String operatorSymbol;

    OperatorType(String operatorSymbol) {
        this.operatorSymbol = operatorSymbol;
    }

    public static OperatorType getOperatorType(String inputOperatorSymbol) {
        return Arrays.stream(OperatorType.values())
                .filter(operatorType -> operatorType.getOperatorSymbol().equals(inputOperatorSymbol))
                .findFirst()
                .orElseThrow(() -> new UnSupportedOperatorException());
    }

    public String getOperatorSymbol() {
        return operatorSymbol;
    }
}
