package com.example.calculator.lv4.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public abstract class CalculatorUtil {
    private static final Logger log = LoggerFactory.getLogger(CalculatorUtil.class);
    private static final Scanner scanner = new Scanner(System.in);
    public static Number inputNumber(String message) {
        while (true) {
            String input = "";
            try {
                input = getInput(message);
                return tryConvertToNumber(input);
            } catch (NumberFormatException e) {
                log.info("숫자를 입력해야합니다. 입력값:{}", input);
            }
        }
    }

    private static String getInput(String message) {
        System.out.print(message);
        return scanner.next();
    }

    private static Number tryConvertToNumber(String input) {
            if (input.contains(".")) {
                return Double.valueOf(input);
            }
            return Integer.valueOf(input);
    }
}
