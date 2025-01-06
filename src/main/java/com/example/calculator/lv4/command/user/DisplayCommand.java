package com.example.calculator.lv4.command.user;

import com.example.calculator.lv4.model.Calculator;

public class DisplayCommand implements Command {
    private final Calculator<Number> calculator;
    public DisplayCommand(Calculator<Number> calculator) {
        this.calculator = calculator;
    }

    @Override
    public CommandResult execute() {
        calculator.display();
        return CommandResult.CONTINUE;
    }
}
