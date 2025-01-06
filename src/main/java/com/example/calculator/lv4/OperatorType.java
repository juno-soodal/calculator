package com.example.calculator.lv4;

import com.example.calculator.lv4.exception.calculator.UnSupportedOperatorException;

public enum OperatorType {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private final String operatorSymbol;

    OperatorType(String operatorSymbol) {
        this.operatorSymbol = operatorSymbol;
    }

    public static OperatorType getOperatorType(String inputOperatorSymbol) {
            OperatorType[] values = OperatorType.values();
            for (OperatorType value : values) {
                if (inputOperatorSymbol.equals(value.getOperatorSymbol())) {
                    return value;
                }
            }
            throw new UnSupportedOperatorException();
    }

    public String getOperatorSymbol() {
        return operatorSymbol;
    }
}
