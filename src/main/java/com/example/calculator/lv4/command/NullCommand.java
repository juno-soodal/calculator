package com.example.calculator.lv4.command;

import com.example.calculator.lv4.exception.global.UnSupportedCommandException;

public class NullCommand implements Command{
    @Override
    public CommandResult execute() {
        throw new UnSupportedCommandException();
    }

}
