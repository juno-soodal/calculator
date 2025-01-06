package com.example.calculator.lv4.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class CalculatorUtil {
    private static final Logger log = LoggerFactory.getLogger(CalculatorUtil.class);
    public static Number inputNumber(String message) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.next();
                return convertToNumber(input);

            } catch (NumberFormatException e) {
                log.warn("Calculator Exception: {}","숫자만 입력 가능합니다.");
            }finally {
                scanner.nextLine();
            }
        }
    }

    private static Number convertToNumber(String input) {
        if (input.contains(".")) {
            return Double.valueOf(input);
        }

        return Integer.valueOf(input);
    }
}
