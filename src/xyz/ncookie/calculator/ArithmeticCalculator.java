package xyz.ncookie.calculator;

import xyz.ncookie.calculator.data.OperatorType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class ArithmeticCalculator {

    protected Queue<BigDecimal> resultQueue = new LinkedList<>();

    public <T extends Number> Optional<BigDecimal> calculate(T a, T b, OperatorType operatorType) {
        BigDecimal result = BigDecimal.ZERO;     // 연산 결과
        boolean isResultValid = false;           // 연산 도중 문제 여부 flag

        BigDecimal bdA = new BigDecimal(String.valueOf(a));
        BigDecimal bdB = new BigDecimal(String.valueOf(b));

        switch (operatorType) {
            case ADD:
                result = bdA.add(bdB);
                isResultValid = true;
                break;
            case SUB:
                result = bdA.subtract(bdB);
                isResultValid = true;
                break;
            case MUL:
                result = bdA.multiply(bdB);
                isResultValid = true;
                break;
            case DIV:
                if (bdB.equals(BigDecimal.ZERO)) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    break;
                }
                result = bdA.divide(bdB, RoundingMode.HALF_EVEN);
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

    public Queue<BigDecimal> getResultQueue() {
        return resultQueue;
    }

    public void setResultQueue(Queue<BigDecimal> resultQueue) {
        this.resultQueue = resultQueue;
    }

    public void removeFirstElementOfResultQueue() {
        System.out.println("첫 번째 데이터 삭제: " + resultQueue.remove());
    }

}
