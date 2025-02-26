package xyz.ncookie.calculator;

import xyz.ncookie.calculator.data.OperatorType;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    static final String SEPARATOR = "======================================\n";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

        // "exit" 키워드 입력 받기 전까지는 무한루프
        while (true) {

            // 사용자로부터 두 정수 입력 받기
            System.out.print("첫 번째 양의 정수 입력: ");
            int a = sc.nextInt();

            System.out.print("두 번째 양의 정수 입력: ");
            int b = sc.nextInt();

            // 입력 조건에 맞지 않는다면 처음부터
            if (a < 0 || b < 0) {
                System.out.println("0을 포함한 양의 정수만 입력할 수 있습니다.");
                System.out.println(SEPARATOR);
                continue;
            }

            System.out.print("사칙연산 기호 입력: ");
//            char operatorChar = sc.next().charAt(0);
            String operatorStr = sc.next();

            // Calculator 연산 수행
//            Optional<Integer> optional_ = arithmeticCalculator.calculate(a, b, operatorChar);
            Optional<Integer> optional = arithmeticCalculator.calculate(a, b, OperatorType.getOperator(operatorStr));
            optional.ifPresent(result -> System.out.println("계산 결과: " + result));

            // "exit"를 입력받으면 루프 종료
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String exitStr = sc.next();
            if (exitStr.equals("exit")) {
                break;
            }

            System.out.println("연산 결과 데이터: " + arithmeticCalculator.getResultQueue());
            List<Integer> resultsBiggerThanInput = arithmeticCalculator.getResultQueue().stream()
                    .filter(v -> v > a && v > b)
                    .toList();
            System.out.println("입력값보다 큰 연산 결과 데이터: " + resultsBiggerThanInput);
            System.out.println(SEPARATOR);

        }
    }

}
