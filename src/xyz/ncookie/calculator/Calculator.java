package xyz.ncookie.calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 양의 정수 입력: ");
            int a = sc.nextInt();

            System.out.print("두 번째 양의 정수 입력: ");
            int b = sc.nextInt();

            System.out.print("사칙연산 기호 입력: ");
            char operator = sc.next().charAt(0);

            if (a < 0 || b < 0) {
                System.out.println("0을 포함한 양의 정수만 입력할 수 있습니다.");
                return;
            }

            int result = 0;     // 연산 결과
            boolean isResultValid = false;  // 연산 도중 문제 여부 flag

            // TODO: 연산의 결과가 자료형의 범위를 벗어났을 때의 처리 방법을 생각해 봐야함
            /*
                - long 타입으로 먼저 계산한 뒤 오버플로우/언더플로우 체크 => 결과가 long 범위보다 크면??
                - 래퍼클래스에는 이러한 예외를 처리할 수 있는 방법이 있지 않을까?
             */
            switch (operator) {
                case '+':
                    result = a + b;
                    isResultValid = true;
                    break;
                case '-':
                    result = a - b;
                    isResultValid = true;
                    break;
                case '*':
                    result = a * b;
                    isResultValid = true;
                    break;
                case '/':
                    if (b == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        break;
                    }
                    result = a / b;
                    isResultValid = true;
                    break;
                default:
                    System.out.println("올바르지 않은 연산자 입력입니다.");
            }

            if (isResultValid) {
                System.out.println("계산 결과: " + result);
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String exitStr = sc.next();
            if (exitStr.equals("exit")) {
                break;
            }
        }
    }

}
