package com.example.calculator.lv4;


import com.example.calculator.lv4.command.*;
import com.example.calculator.lv4.exception.global.ExitCommandException;
import com.example.calculator.lv4.operator.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CalculatorApp {

    private static final Logger log = LoggerFactory.getLogger(CalculatorApp.class);

    public static void main(String[] args) {
        Map<OperatorType, Operation> operationMap = new HashMap<>();
        operationMap.put(OperatorType.PLUS, new AddOperation());
        operationMap.put(OperatorType.MINUS, new SubStractOperation());
        operationMap.put(OperatorType.MULTIPLY, new MultiplyOperation());
        operationMap.put(OperatorType.DIVIDE, new DivideOperation());
        OperationManager operationManager = new OperationManager(operationMap);
        Calculator<Number> calculator = new Calculator<>(operationManager);

        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("exit",new ExitCommand());
        commandMap.put("remove",new RemoveCommand(calculator));
        commandMap.put("upper",new UpperCommand(calculator));
        commandMap.put("display",new DisplayCommand(calculator));
        commandMap.put("again",new AgainCommand());
        CommandManager commandManager = new CommandManager(commandMap);

        CalculatorService calculatorService = new CalculatorService(calculator,commandManager);

        try {
            log.info("계산기 프로그램 실행");
            calculatorService.start();
        } catch (ExitCommandException e) {
            log.info("Calculator Exception: {}", e.getMessage());
        }

    }


}
