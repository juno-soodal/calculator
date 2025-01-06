package com.example.calculator.lv4.exception.global;

import com.example.calculator.lv4.exception.ErrorMessage;

public class ExitCommandException extends GlobalException{

    public ExitCommandException() {
        super(ErrorMessage.EXIT_COMMAND);
    }
    public ExitCommandException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
