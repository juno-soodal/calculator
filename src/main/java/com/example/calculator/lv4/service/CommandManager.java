package com.example.calculator.lv4.service;

import com.example.calculator.lv4.command.user.Command;
import com.example.calculator.lv4.command.user.CommandResult;
import com.example.calculator.lv4.command.user.NullCommand;

import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commandMap;
    private final Command nullCommand = new NullCommand();

    public CommandManager(Map<String, Command> commandMap) {
        this.commandMap = commandMap;
    }

    public CommandResult execute(String inputCommand) {
        Command command = commandMap.getOrDefault(inputCommand,nullCommand);
        return command.execute();
    }
}
