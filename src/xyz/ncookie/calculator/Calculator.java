package xyz.ncookie.calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 양의 정수 입력: ");
        int a = sc.nextInt();

        System.out.print("두 번째 양의 정수 입력: ");
        int b = sc.nextInt();

        if (a < 0 || b < 0) {
            System.out.println("0을 포함한 양의 정수만 입력할 수 있습니다.");
        }

        System.out.print("사칙연산 기호 입력: ");
        char operator = sc.next().charAt(0);
        System.out.println(operator);
    }

}
