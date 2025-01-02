package com.example.calculator.lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {
    // getNumber, getOperator 공통으로 사용해서 전역 변수로 지정
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            Integer firstNumber = getNumber("첫번째 숫자: ");
            Integer secondNumber = getNumber("두번째 숫자: ");
            String operator = getOperator();
            double result = calculate(operator, firstNumber, secondNumber);
            System.out.println(firstNumber + " " + operator + " " + secondNumber + " = "  + result);
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = scanner.nextLine();
            if (exit.equals("exit")) {
                break;
            }
        }

    }

    private static double calculate(String operator, Integer firstNumber, Integer secondNumber) {
        switch (operator) {
            case "+" :
                return firstNumber + secondNumber;
            case "-":
                return  firstNumber - secondNumber;
            case "*":
                return  firstNumber * secondNumber;
            case "/":
                return  (double) firstNumber / secondNumber;
            default:
                return 0;
        }
    }


    private static Integer getNumber(String message) {
        Integer inputNumber;
        while (true) {
            try {
                System.out.print(message);
                inputNumber = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력 가능합니다.");

            } finally {
                scanner.nextLine();
            }
        }
        return inputNumber;
    }

    private static String getOperator() {
        String operator;
        while (true) {
            System.out.print("연산기호: ");
            operator = scanner.nextLine();
            if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                break;
            }
            System.out.println("연산기호는 + , - , * , / 중에서 입력하세요");
        }
        return operator;
    }
}
