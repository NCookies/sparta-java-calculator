package xyz.ncookie.calculator;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Calculator {

    private Queue<Integer> resultQueue = new LinkedList<>();

    public Optional<Integer> calculate(int a, int b, char operator) {
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

        // 정상적으로 연산이 수행되었을 때에만 결과 출력
        if (isResultValid) {
            resultQueue.offer(result);
            return Optional.of(result);
        } else {
            // 연산 도중 문제가 발생했다면 null 반환
            return Optional.empty();
        }
    }

    public Queue<Integer> getResultQueue() {
        return resultQueue;
    }

    public void setResultQueue(Queue<Integer> resultQueue) {
        this.resultQueue = resultQueue;
    }

    public void removeFirstElementOfResultQueue() {
        System.out.println("첫 번째 데이터 삭제: " + resultQueue.remove());
    }

}
