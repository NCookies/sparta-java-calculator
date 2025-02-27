package calculator;

import data.OperatorType;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

public class ArithmeticCalculator {

    protected Queue<BigDecimal> resultQueue = new LinkedList<>();

    /*
     * BigDecimal 연산 중 ArithmeticException가 발생하는 경우는 크게 3개가 있다.
     * 1. / by zero (0으로 나누기 오류)
     * 2. Non-terminating decimal expansion; no exact representable decimal result: RoundingMode 파라미터가 설정되지 않은 상태에서 divide(...) 연산 결과가 무한소수일 때 발생
     * 3. Rounding necessary: RoundingMode가 UNNECESSARY인데 divide(...) 연산 결과가 무한소수일 때 발생
     *
     * 즉, 아래 코드에서 ArithmeticException는 b가 0일 때만 throw 된다.
     */
    public <T> BigDecimal calculate(T a, T b, OperatorType operatorType) throws ArithmeticException {
        // 어떤 데이터 타입이 들어오더라도 BigDecimal 타입으로 변환
        BigDecimal bdA = new BigDecimal(String.valueOf(a));
        BigDecimal bdB = new BigDecimal(String.valueOf(b));

        // 연산 수행 후 결과 저장 및 반환
        BigDecimal result = operatorType.calculate(bdA, bdB);
        resultQueue.offer(result);

        return result;
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
