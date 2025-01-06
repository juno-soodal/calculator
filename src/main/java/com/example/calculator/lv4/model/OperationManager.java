package com.example.calculator.lv4.model;

import com.example.calculator.lv4.service.OperatorType;
import com.example.calculator.lv4.command.operator.NullOperation;
import com.example.calculator.lv4.command.operator.Operation;

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
