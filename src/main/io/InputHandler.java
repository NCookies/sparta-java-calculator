package io;

import data.CalcParam;
import data.OperatorType;
import exception.InvalidOperatorException;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class InputHandler {

    private final static String EXIT_STR = "exit";

    public CalcParam readParams() throws NumberFormatException, InvalidOperatorException {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 피연산자 입력: ");
        BigDecimal numX = new BigDecimal(sc.next());

        System.out.print("두 번째 피연산자 입력: ");
        BigDecimal numY = new BigDecimal(sc.next());

        System.out.print("사칙연산 기호 입력: ");
        String operatorStr = sc.next();
        OperatorType operator = OperatorType.getOperator(operatorStr);

        return new CalcParam(numX, numY, operator);
    }

    public boolean readExitFlag() {
        Scanner sc = new Scanner(System.in);
        System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");

        return sc.next().equals(EXIT_STR);
    }

}
