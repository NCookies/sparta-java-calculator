# 개요
콘솔에서 사용자로부터 피연산자 2개와 연산자를 입력받아 사칙연산 등을 수행하는 계산기 프로그램이다.

# 기술 스택
- Java 17
- JUnit5
- AssertJ

# 사용툴
- IntelliJ
- [Github Projects](https://github.com/users/NCookies/projects/21)

# 기능

## Flow

### 사용자로부터 두 개의 숫자와 연산자를 입력 받는다.
  - 추후 용이한 확장을 위해 입출력을 담당하는 클래스를 분리해두었다. (입력 시 함께 출력되는 텍스트는 입력 핸들링 클래스에 포함시켰다.)
  - 만약 이 때 유효하지 않은 숫자 데이터(ex) 0.1s, f3 등)나 지정되지 않은 연산자(`OperatorType`에 정의되지 않은 연산자`)를 입력 받으면 예외를 throw해서 처리한다.
  - 프로그램 실행을 위해 `Main`에서 다양한 클래스 인스턴스를 생성해 사용하며, 여기서 일괄적으로 예외들을 처리한다.
### 입력 받은 데이터를 기반으로 연산을 수행한다.
  - 제네릭을 사용해 `calculate(...)` 메소드에는 String, int, double 등 다양한 형태의 데이터 타입을 전달할 수 있다.
  - 이를 검증하기 위해 간단한 [테스트 코드](src/test/calculator/ArithmeticCalculatorTest.java)를 작성했다.
  - 소수를 정확하게 표현하고 큰 범위의 숫자 데이터도 최대한 손실이 없도록 하기 위해 `calculate(...)` 메소드의 반환 타입은 `BigDecimal`을 사용한다.
### 연산 결과 또는 에러 처리 등의 메세지를 콘솔에 출력한다.
  - stream()을 활용해 연산 결과 리스트와 관련된 다양한 내용을 출력한다.
  - 이후 프로그램을 계속할지 확인하고, "exit"를 입력받으면 루프와 함께 프로그램을 종료한다.


## 입력
콘솔에서 피연산자와 연사자를 입력받는다. 

연산 결과가 출력된 후에 "exit"를 입력하면 프로그램이 종료된다. 만약 다른 값을 입력하면 루프의 처음으로 돌아가 입력을 받는 기능을 수행한다. 

## 출력
사용자로부터 받은 입력값을 사용하여 연산 수행 후, 결과값과 그와 관련된 값들을 출력한다.

## 연산
사용자로부터 받은 입력값으로 연산을 수행한다. 현재는 기본적인 사칙연산만 구현되어 있다.

## 저장
연산의 결과값을 저장한다. 

이 값들을 활용해 다양한 조건의 결과들을 출력할 수 있다.

ex) 결과값 중 가장 크거나 작은 수, 입력값보다 큰 수 등

## 예외 처리

프로그램 동작 중 발생할 수 있는 문제인 아래 예외들을 `try ~ catch`로 핸들링하고 있다.

- `NumberFormatException`: 피연산자로 숫자가 아닌 데이터를 입력받았을 때 발생
- `InvalidOperatorException`: 커스텀 예외 클래스. 지정된 연산자 외의 값을 입력받았을 때 발생
- `ArithmeticException`: 나눗셈 연산에서 피제수가 0일 때 발생

## 테스트 코드
`@ParameterizedTest`로 `calculate(...)` 메소드에 어떤 타입의 숫자 데이터가 들어와도 정상적으로 동작하는지 테스트한다.

# 관련 문서
- 트러블슈팅
  - [[TIL] 자바 계산기 구현 중 트러블슈팅](https://velog.io/@ncookie/TIL-%EC%9E%90%EB%B0%94-%EA%B3%84%EC%82%B0%EA%B8%B0-%EA%B5%AC%ED%98%84-%EC%A4%91-%ED%8A%B8%EB%9F%AC%EB%B8%94%EC%8A%88%ED%8C%85)
- TIL
  - [[Java] float vs double vs BigDecimal](https://velog.io/@ncookie/Java-float-vs-double-vs-BigDecimal)
  - [[Java] BigDecimal 사용 시 ArithmeticException 발생하는 경우](https://velog.io/@ncookie/Java-BigDecimal-%EC%82%AC%EC%9A%A9-%EC%8B%9C-ArithmeticException-%EB%B0%9C%EC%83%9D%ED%95%98%EB%8A%94-%EA%B2%BD%EC%9A%B0)
  - [[TIL] JUnit5 @MethodSource 사용하여 테스트 코드 작성](https://velog.io/@ncookie/TIL-JUnit5-MethodSource-%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%BD%94%EB%93%9C-%EC%9E%91%EC%84%B1)

# 버전별 브랜치
과제의 명세서에 작성된 난이도별로 브랜치를 분리해두었다.

- [필수 기능 - Lv1](https://github.com/NCookies/sparta-java-calculator/tree/feature/%232-no-class-calculator)
- [필수 기능 - Lv2](https://github.com/NCookies/sparta-java-calculator/tree/feature/%238-with-class-calculator)
- [도전 기능](https://github.com/NCookies/sparta-java-calculator/tree/feature/%2310-enhanced-calculator)
- [최종 버전](https://github.com/NCookies/sparta-java-calculator)

프로젝트 히스토리 및 이슈 등은 [Github Projects](https://github.com/users/NCookies/projects/21)에서 확인할 수 있다.

# 실제 동작
```
첫 번째 피연산자 입력: 3
두 번째 피연산자 입력: 2
사칙연산 기호 입력: +
***********************
연산 결과: 5
***********************
[연산 결과 기록] 5
[입력값보다 큰 연산 결과] 5
더 계산하시겠습니까? (exit 입력 시 종료): no
======================================

첫 번째 피연산자 입력: -5
두 번째 피연산자 입력: -3
사칙연산 기호 입력: *
***********************
연산 결과: 15
***********************
[연산 결과 기록] 5, 15
[입력값보다 큰 연산 결과] 5, 15
더 계산하시겠습니까? (exit 입력 시 종료): no
======================================

첫 번째 피연산자 입력: 5
두 번째 피연산자 입력: 3
사칙연산 기호 입력: -
***********************
연산 결과: 2
***********************
[연산 결과 기록] 5, 15, 2
[입력값보다 큰 연산 결과] 15
더 계산하시겠습니까? (exit 입력 시 종료):
```

