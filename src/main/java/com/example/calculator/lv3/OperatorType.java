package com.example.calculator.lv3;

import java.util.Arrays;
import java.util.Scanner;

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
                .orElseThrow(() -> new IllegalArgumentException("연산기호는 + , - , * , / 중에서 입력하세요 :" + inputOperatorSymbol));
    }

    public String getOperatorSymbol() {
        return operatorSymbol;
    }
}
