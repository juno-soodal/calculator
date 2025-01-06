package com.example.calculator.lv4;

import com.example.calculator.lv4.operator.NullOperation;
import com.example.calculator.lv4.operator.Operation;

import java.util.Map;

public class OperationManager {

    private final Map<OperatorType, Operation> operationMap;
    private final Operation noOperation = new NullOperation();

    public OperationManager(Map<OperatorType, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    public Operation getOperation(OperatorType operatorType) {
        return operationMap.getOrDefault(operatorType, noOperation);
    }
}
