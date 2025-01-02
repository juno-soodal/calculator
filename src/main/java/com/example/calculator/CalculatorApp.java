package com.example.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Integer firstNumber =null ;
            while (true) {
                try {
                    System.out.print("첫번째 숫자: ");
                    firstNumber = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("숫자만 입력 가능합니다.");

                }finally {
                    scanner.nextLine();
                }
            }
            Integer secondNumber = null;
            while (true) {
                try {
                    System.out.print("두번째 숫자: ");
                    secondNumber = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("숫자만 입력 가능합니다.");
                }finally {
                    scanner.nextLine();
                }
            }
            String operator = null;
            while (true) {
                System.out.print("연산기호: ");
                operator = scanner.nextLine();
                if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                    break;
                }
                System.out.println("연산기호는 + , - , * , / 중에서 입력하세요");
            }

            double result = 0;
            switch (operator) {
                case "+" :
                    result =firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = (double) firstNumber / secondNumber;
                    break;
            }
            System.out.println(firstNumber + " " + operator + " " + secondNumber + " = "  + result);
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = scanner.nextLine();
            if (exit.equals("exit")) {
                break;
            }
        }

    }
}
