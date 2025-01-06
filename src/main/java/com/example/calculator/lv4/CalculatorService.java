package com.example.calculator.lv4;

import com.example.calculator.lv4.command.CommandResult;
import com.example.calculator.lv4.exception.calculator.NoCalculationResultException;
import com.example.calculator.lv4.exception.global.UnSupportedCommandException;
import com.example.calculator.lv4.exception.calculator.UnSupportedOperatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static com.example.calculator.lv4.util.CalculatorUtil.inputNumber;


public class CalculatorService {
    private static final Scanner scanner = new Scanner(System.in);
    private final Calculator<Number> calculator;
    private final CommandManager commandManager;

    private static final Logger log = LoggerFactory.getLogger(CalculatorService.class);

    public CalculatorService(Calculator<Number> calculator, CommandManager commandManager) {
        this.calculator = calculator;
        this.commandManager = commandManager;
    }

    public void start() {


        while (true) {
            Number firstNumber  = inputNumber("첫번째 숫자: ");
            Number secondNumber = inputNumber("두번째 숫자: ");
            OperatorType operatorType = inputOperatorType();


            Number result = calculator.calculate(operatorType, firstNumber, secondNumber);
            if (result != null) {
                calculator.addNumber(result);
                calculator.printResult(firstNumber, secondNumber,operatorType,result);
            }

            while (true) {
                System.out.print("더 계산하시겠습니까? [again 진행|exit 종료|remove 삭제|display 출력|upper 초과값]");
                String inputCommand = scanner.next();
                try {
                    CommandResult commandResult = commandManager.execute(inputCommand);
                    if (commandResult == CommandResult.BREAK) {
                        break;
                    }
                } catch (UnSupportedCommandException e) {
                    System.out.println("현재 지원하지 않는 명령어 입니다.");
                    log.warn("Global Exception: {}", e.getMessage());

                } catch (NoCalculationResultException e) {
                    System.out.println("현재 저장 된 값이 없습니다.");
                    log.warn("Calculator Exception: {}", e.getMessage());
                }finally {
                    scanner.nextLine();
                }
            }
        }
    }

    private OperatorType inputOperatorType() {
        while (true) {
            try {
                System.out.print("연산기호: ");
                String inputOperatorSymbol = scanner.next();
                return OperatorType.getOperatorType(inputOperatorSymbol);
            } catch (UnSupportedOperatorException e) {

                System.out.println("연산기호는 + , - , * , / 중에서 입력하세요");
                log.warn("잘못 된 연산기호 입력값:{}",e.getMessage());
            }finally {
                scanner.nextLine();
            }
        }
    }
}
