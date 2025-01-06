package com.example.calculator.lv4.command;

import com.example.calculator.lv4.Calculator;

import java.util.Scanner;

import static com.example.calculator.lv4.util.CalculatorUtil.inputNumber;

public class UpperCommand implements Command{
    private final Calculator<Number> calculator;

    public UpperCommand(Calculator<Number> calculator) {
        this.calculator = calculator;
    }

    @Override
    public CommandResult execute() {
        Number limitValue = inputNumber("기준값:");
        calculator.findValuesAboveLimit(limitValue);
        return CommandResult.CONTINUE;
    }




}
