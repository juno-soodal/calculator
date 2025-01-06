package com.example.calculator.lv4.exception;

public enum ErrorMessage {
    //Calculator Exception
    DIVIDE_BY_ZERO("나눗셈은 0으로 나눌 수 없습니다."),
    NO_CALCULATION_RESULT("값이 비어 있습니다."),
    UN_SUPPORTED_OPERATOR("연산기호는 + , - , * , / 중에서 입력하세요 "),

    //Global Exception
    EXIT_COMMAND("프로그램을 종료합니다."),
    UN_SUPPORTED_COMMAND("현재 없는 명령어 입니다.");

    private String defaultMessage;

    ErrorMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
