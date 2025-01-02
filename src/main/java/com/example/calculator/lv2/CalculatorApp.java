package com.example.calculator.lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp {
    // getNumber, getOperator 공통으로 사용해서 전역 변수로 지정
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator calculator = new Calculator(new ArrayList<>());
        while (true) {
            Double firstNumber = getNumber("첫번째 숫자: ");
            Double secondNumber = getNumber("두번째 숫자: ");
            String operator = getOperator();
            calculator.setFirstNumber(firstNumber);
            calculator.setSecondNumber(secondNumber);
            calculator.setOperator(operator);
            double result =calculator.calculate();
            calculator.addNumber(result);
            System.out.println(firstNumber + " " + operator + " " + secondNumber + " = "  + result);
            System.out.print("더 계산하시겠습니까? (exit 종료|remove 삭제|result 출력)");

            String command = scanner.nextLine();

            if (command.equals("exit")) {
                break;
            }
            if (command.equals("result")) {
                calculator.printAll();
            }
            if (command.equals("remove")) {
                calculator.removeFirst();
            }
            
        }
    }

    private static Double getNumber(String message) {
        Double inputNumber;
        while (true) {
            try {
                System.out.print(message);
                inputNumber = scanner.nextDouble();
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
