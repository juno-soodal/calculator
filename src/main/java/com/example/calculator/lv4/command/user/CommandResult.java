package com.example.calculator.lv4.command.user;

public enum CommandResult {
    CONTINUE("진행"), BREAK("종료");

    private final String description;
    CommandResult(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
