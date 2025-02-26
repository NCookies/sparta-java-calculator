package xyz.ncookie.calculator;

import xyz.ncookie.calculator.data.OperatorType;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class ArithmeticCalculator {

    protected Queue<BigDecimal> resultQueue = new LinkedList<>();

    public <T> Optional<BigDecimal> calculate(T a, T b, OperatorType operatorType) {
        BigDecimal result;     // 연산 결과

        // 어떤 데이터 타입이 들어오더라도 BigDecimal 타입으로 변환
        BigDecimal bdA = new BigDecimal(String.valueOf(a));
        BigDecimal bdB = new BigDecimal(String.valueOf(b));

        try {
            // 연산 수행 후 결과 저장 및 반환
            result = operatorType.calculate(bdA, bdB);
            resultQueue.offer(result);
            return Optional.of(result);
        } catch (ArithmeticException e) {
            // 연산 도중 에러가 발생했다면 null 반환
            System.out.println(e.getMessage());
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
        if (!resultQueue.isEmpty()) {
            System.out.println("첫 번째 데이터 삭제: " + resultQueue.remove());
        } else {
            System.out.println("현재 큐가 비어있습니다");
        }
    }

}
