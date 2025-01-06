package com.example.calculator.lv4.exception.global;

import com.example.calculator.lv4.exception.ErrorMessage;

public class UnSupportedCommandException extends GlobalException{

    public UnSupportedCommandException() {
        super(ErrorMessage.UN_SUPPORTED_COMMAND);
    }
    public UnSupportedCommandException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
