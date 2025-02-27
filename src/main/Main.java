import calculator.ArithmeticCalculator;
import data.CalcParam;
import exception.InvalidOperatorException;
import io.InputHandler;
import io.OutputHandler;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

        // "exit" 키워드 입력 받기 전까지는 무한루프
        while (true) {
            CalcParam calcParam;

            // 사용자로부터 두 숫자 입력 받기
            try {
                calcParam = inputHandler.readParams();
            } catch (NumberFormatException e) {
                outputHandler.printError("유효하지 않은 형식의 숫자입니다.");
                continue;
            } catch (InvalidOperatorException e) {
                outputHandler.printError(e.getMessage());
                continue;
            }

            // 연산 수행
            try {
                // calcParam을 통째로 파라미터로 넘기고 싶지만 제네릭을 사용해야 해서 패스
                BigDecimal result = arithmeticCalculator.calculate(
                        calcParam.numX(),
                        calcParam.numY(),
                        calcParam.operatorType());
                outputHandler.printCalcResult(String.valueOf(result));
            } catch (ArithmeticException e) {
                outputHandler.printError(e.getMessage());
            }

            outputHandler.printCustomMsg(
                    "연산 결과 기록",
                    arithmeticCalculator.getResultQueue().stream()
                            .map(String::valueOf).collect(Collectors.joining(", "))
            );
            outputHandler.printCustomMsg(
                    "입력값보다 큰 연산 결과",
                    arithmeticCalculator.getResultQueue().stream()
                            .filter(v -> v.compareTo(calcParam.numX()) > 0 && v.compareTo(calcParam.numY()) > 0)
                            .map(String::valueOf).collect(Collectors.joining(", "))
            );

            // "exit"를 입력받으면 루프 종료
            if (inputHandler.readExitFlag()) {
                break;
            }

            outputHandler.printSeparator();

        }
    }

}
