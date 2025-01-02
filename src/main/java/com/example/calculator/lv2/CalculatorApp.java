package com.example.calculator.lv2;

import com.example.calculator.lv2.operator.*;

import java.util.*;

public class CalculatorApp {
    // getNumber, getOperator 공통으로 사용해서 전역 변수로 지정
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Map<String, Operation> operations = new HashMap<>();
        operations.put("+", new AddOperation());
        operations.put("-", new SubStractOperation());
        operations.put("*", new MultiplyOperation());
        operations.put("/", new DivideOperation());

        Calculator calculator = new Calculator(operations);
        while (true) {
            Integer firstNumber = getNumber("첫번째 숫자: ");
            Integer secondNumber = getNumber("두번째 숫자: ");
            String operator = getOperator();
            double result =calculator.calculate(operator, firstNumber, secondNumber);

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
                Double removedNumber = calculator.removeFirst();
                System.out.println("삭제 된 값:" + removedNumber);
            }
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
