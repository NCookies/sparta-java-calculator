package xyz.ncookie.calculator;

import xyz.ncookie.calculator.data.OperatorType;

import java.util.Optional;

public class ArithmeticCalculator extends Calculator {

    public <T extends Number> Optional<Number> calculate(T a, T b, OperatorType operatorType) {
        Number result = null;     // 연산 결과
        boolean isResultValid = false;  // 연산 도중 문제 여부 flag

        switch (operatorType) {
            case ADD:
                result = a.doubleValue() + b.doubleValue();
                isResultValid = true;
                break;
            case SUB:
                result = a.doubleValue() - b.doubleValue();
                isResultValid = true;
                break;
            case MUL:
                result = a.doubleValue() * b.doubleValue();
                isResultValid = true;
                break;
            case DIV:
                if (b.doubleValue() == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    break;
                }
                result = a.doubleValue() / b.doubleValue();
                isResultValid = true;
                break;
            default:
                System.out.println("올바르지 않은 연산자 입력입니다.");
        }

        // 정상적으로 연산이 수행되었을 때에만 결과 출력
        if (isResultValid) {
            resultQueue.offer(result);
            return Optional.of(result);
        } else {
            // 연산 도중 문제가 발생했다면 null 반환
            return Optional.empty();
        }
    }

    public Optional<Integer> add(Integer a, Integer b, OperatorType operatorType) {
        return Optional.empty();
    }

    public Optional<Double> add(Double a, Double b, OperatorType operatorType) {
        return Optional.empty();
    }

}
