package com.example.calculator.lv4.exception.global;

import com.example.calculator.lv4.exception.ErrorMessage;

public class GlobalException extends RuntimeException{
    private String message;

    public GlobalException(ErrorMessage errorMessage) {
        super(errorMessage.getDefaultMessage());
        this.message = errorMessage.getDefaultMessage();
    }

}
