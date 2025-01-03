package com.example.calculator.lv3;



import com.example.calculator.lv3.operator.*;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CalculatorApp {
    // getNumber, getOperator 공통으로 사용해서 전역 변수로 지정
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Map<OperatorType, Operation> operations = new HashMap<>();
        operations.put(OperatorType.PLUS, new AddOperation());
        operations.put(OperatorType.MINUS, new SubStractOperation());
        operations.put(OperatorType.MULTIPLY, new MultiplyOperation());
        operations.put(OperatorType.DIVIDE, new DivideOperation());

        Calculator calculator = new Calculator(operations);

        while (true) {

            Integer firstNumber = getNumber("첫번째 숫자: ");
            Integer secondNumber = getNumber("두번째 숫자: ");
            
            OperatorType operatorType;
            while (true) {
                String inputOperatorSymbol = inputOperatorSymbol();
                try {
                    operatorType = OperatorType.getOperatorType(inputOperatorSymbol);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            double result = calculator.calculate(operatorType, firstNumber, secondNumber);
            if (!Double.isNaN(result)) {
                calculator.addNumber(result);
                calculator.printResult(firstNumber,secondNumber,operatorType,result);
            }

            System.out.print("더 계산하시겠습니까? (exit 종료|remove 삭제|result 출력)");
            String command = scanner.nextLine();
            if (command.equals("exit")) {
                break;
            }
            if (command.equals("result")) {
                calculator.printAllResult();
            }
            if (command.equals("remove")) {
                calculator.removeFirst();
            }
        }
    }

    private static String inputOperatorSymbol() {
        String inputOperatorSymbol;
        while (true) {
            System.out.print("연산기호: ");
            inputOperatorSymbol = scanner.nextLine();
            if (!inputOperatorSymbol.isEmpty()) {
                return inputOperatorSymbol;
            }
            System.out.println("연산기호를 입력하세요");
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
}
