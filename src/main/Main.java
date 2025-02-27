import calculator.ArithmeticCalculator;
import data.CalcParam;
import data.OperatorType;
import exception.InvalidOperatorException;
import io.InputHandler;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    static final String SEPARATOR = "======================================\n";

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

        // "exit" 키워드 입력 받기 전까지는 무한루프
        while (true) {
            CalcParam calcParam;

            // 사용자로부터 두 숫자 입력 받기
            try {
                calcParam = inputHandler.readParams();
            } catch (NumberFormatException e) {
                System.out.println("유효하지 않은 형식의 숫자입니다.");
                continue;
            } catch (InvalidOperatorException e) {
                System.out.println(e.getMessage());
                continue;
            }

            // 연산 수행
            // calcParam을 통째로 파라미터로 넘기고 싶지만 제네릭을 사용해야 해서 패스
            Optional<BigDecimal> optional = arithmeticCalculator.calculate(
                    calcParam.numX(),
                    calcParam.numY(),
                    calcParam.operatorType());
            optional.ifPresent(result -> System.out.println("계산 결과: " + result));

            System.out.println("연산 결과 데이터: " + arithmeticCalculator.getResultQueue());
            List<BigDecimal> resultsBiggerThanInput = arithmeticCalculator.getResultQueue().stream()
                    .filter(v -> v.compareTo(calcParam.numX()) > 0 && v.compareTo(calcParam.numY()) > 0)
                    .toList();
            System.out.println("입력값보다 큰 연산 결과 데이터: " + resultsBiggerThanInput);
            System.out.println(SEPARATOR);

            // "exit"를 입력받으면 루프 종료
            if (inputHandler.readExitFlag()) {
                break;
            }

        }
    }

}
