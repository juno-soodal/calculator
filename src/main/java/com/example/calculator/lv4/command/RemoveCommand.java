package com.example.calculator.lv4.command;

import com.example.calculator.lv4.Calculator;

public class RemoveCommand implements Command{
    private final Calculator<Number> calculator;

    public RemoveCommand(Calculator<Number> calculator) {
        this.calculator = calculator;
    }

    @Override
    public CommandResult execute() {
        calculator.removeFirst();
        return CommandResult.CONTINUE;
    }
}
