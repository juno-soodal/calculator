package com.example.calculator.lv4.command;

import com.example.calculator.lv4.exception.global.ExitCommandException;

public class ExitCommand implements Command{
    @Override
    public CommandResult execute() {
        throw new ExitCommandException();
    }
}
