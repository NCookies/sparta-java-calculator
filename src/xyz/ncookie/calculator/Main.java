package xyz.ncookie.calculator;

import xyz.ncookie.calculator.data.OperatorType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    static final String SEPARATOR = "======================================\n";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

        // "exit" 키워드 입력 받기 전까지는 무한루프
        while (true) {
            BigDecimal numX, numY;

            // 사용자로부터 두 숫자 입력 받기
            try {
                System.out.print("첫 번째 피연산자 입력: ");
                numX = new BigDecimal(sc.next());

                System.out.print("두 번째 피연산자 입력: ");
                numY = new BigDecimal(sc.next());

            } catch (NumberFormatException e) {
                System.out.println("올바르지 않은 형식의 숫자입니다.");
                continue;
            }

            System.out.print("사칙연산 기호 입력: ");
            String operatorStr = sc.next();
            
            OperatorType operator = OperatorType.getOperator(operatorStr);
            if (operator == null) {
                System.out.println("올바르지 않은 연산자 입력입니다.");
                continue;
            }

            // Calculator 연산 수행
            Optional<BigDecimal> optional = arithmeticCalculator.calculate(numX, numY, operator);
            optional.ifPresent(result -> System.out.println("계산 결과: " + result));

            // "exit"를 입력받으면 루프 종료
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String exitStr = sc.next();
            if (exitStr.equals("exit")) {
                break;
            }
            System.out.println("연산 결과 데이터: " + arithmeticCalculator.getResultQueue());
            List<BigDecimal> resultsBiggerThanInput = arithmeticCalculator.getResultQueue().stream()
                    .filter(v -> v.compareTo(numX) > 0 && v.compareTo(numY) > 0)
                    .toList();
            System.out.println("입력값보다 큰 연산 결과 데이터: " + resultsBiggerThanInput);
            System.out.println(SEPARATOR);

        }
    }

}
