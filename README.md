# Calculator App

## 프로젝트 설명
사용자가 입력한 두 숫자와 연산자를 기반으로 산술연산을 수행합니다.
연산기호는 +, -, *, / 4가지 있습니다.
예외 처리 및 명령어 기반의 추가 기능도 있습니다.
* * *
## 기능
- 사칙연산
- 명령어 처리
- - exit:프로그램을 종료합니다.
- - save:계산 결과를 저장합니다.
- - again:다시 계산을 진행합니다. 
- - display:저장된 계산 결과를 출력합니다.
- - remove:저장된 첫번째 값을 삭제합니다.
- - upper:입력값보다 큰 값 들을 출력합니다.
- 예외 처리:
- - 연산 예외:
- - - 사칙 연산에 없는 연산자 예외 처리
- - - 0을 나눌 시 예외 처리
- - - 빈 배열의 값 삭제 예외 처리
- - 기타 예외:
- - - 프로그램 종료 예외 처리
- - - 없는 명령어 예외 처리
* * *
## 사용 방법

### 프로그램 실행 후, 다음과 같은 형식으로 진행됩니다.
1. 첫 번째 숫자를 입력합니다.
2. 두 번째 숫자를 입력합니다.
3. 연산자를 입력합니다.
4. 명령어를 입력합니다. [exit,again, display, remove, upper]
* * *
## 코드 구조

    -lv4
        -command:
            -operator
                AddOperation:더하기 연산 처리
                DivideOperation:나누기 연산 처리
                MultiplyOepration:곱하기 연산 처리
                NullOperation:null 연산 처리
                Operation:인터페이스
                SubStractOperation:뺴기 연산 처리
            -user
                AgainCommand:다시 시작 명령 처리
                Command:인터페이스
                CommandResult:명령어 종료,진행 관리
                DisplayCommand:저장 결과 출력 처리
                ExitCommand:프로그램 종료 처리
                NullCommand:null 명령어 처리
                RemoveCommand:삭제 명령어 처리
                UpperCommand:기준값 명령어 처리
        -exception
            -calculator
                CalculatorException:계산기 예외 부모
                DivideByZeroException
                NoCalculationResult
                UnsupportedOperatorException
            -global
                ExitCommandException
                GlobalException:기타 예외 부모
                UnsupportedCommandException:
            ErrorMessage:기본 에러 메시지 공통 관리
        -model
            Calculator:연산 실행, 결과 저장, 삭제. 출력 처리
            OperationManager:연산 실행 관리
        -service
            CalculatorService:계산기 실행, 사용자 명령어 실행 서비스
            CommandManager:사용자 입력 명령어 실행 관리
            OperatorType:계산기에서 사용하는 사칙연산기호를 관리
        -util:유틸관리하는 패키지
            CalculatorUtil:사용자의 입력값을 받고 숫자로 변환처리 하는 공통 유틸
        CalculatorApp:메인 메서드 설정 값을 셋팅하고 CalculatorService 실행


