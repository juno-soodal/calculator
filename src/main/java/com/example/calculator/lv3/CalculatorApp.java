package com.example.calculator.lv3;




import java.util.List;
import java.util.Scanner;

public class CalculatorApp {
    // getNumber, getOperator 공통으로 사용해서 전역 변수로 지정
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        Calculator<Number> calculator = new Calculator<>();

        while (true) {

            Number firstNumber  = inputNumber("첫번째 숫자: ");
            Number secondNumber = inputNumber("두번째 숫자: ");
            
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
            try {
                Number result = calculator.calculate(operatorType, firstNumber, secondNumber);
                List<Number> list = calculator.getList();
                list.add(result);
                calculator.setList(list);
                calculator.printResult(firstNumber,secondNumber,operatorType,result);
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }


            System.out.print("더 계산하시겠습니까? (exit 종료|remove 삭제|result 출력|upper 초과값)");
            String command = scanner.nextLine();
            if (command.equals("exit")) {
                break;
            }
            if (command.equals("remove")) {
                calculator.removeFirst();
            }
            if (command.equals("upper")) {
                Number limitValue = inputNumber("기준값:");
                calculator.findValuesAboveLimit(limitValue);
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

    private static Number inputNumber(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.next();
                return convertToNumber(input);

            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력 가능합니다.");
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
