package com.example.calculator.lv4.command;

public class AgainCommand implements Command{
    @Override
    public CommandResult execute() {
        //명령어 반복 종료
        return CommandResult.BREAK;
    }
}
