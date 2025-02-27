package calculator;

import data.OperatorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ArithmeticCalculatorTest {

    private final ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

    @DisplayName("계산기 파라미터 테스트 - int")
    @ParameterizedTest
    @MethodSource("validIntInput")
    void 계산기_파라미터_테스트_int(int a, int b, OperatorType operatorType, int expected) {
        // Given

        // When
        BigDecimal actual = arithmeticCalculator.calculate(a, b, operatorType);

        // Then
        assertThat(actual).isEqualTo(new BigDecimal(String.valueOf(expected)));
    }

    @DisplayName("계산기 파라미터 테스트 - double")
    @ParameterizedTest
    @MethodSource("validDoubleInput")
    void 계산기_파라미터_테스트_double(double a, double b, OperatorType operatorType, double expected) {
        // Given

        // When
        BigDecimal actual = arithmeticCalculator.calculate(a, b, operatorType);

        // Then
        // double -> BigDecimal 변환하면서 불필요한 0을 제거해줘야 함
        assertThat(actual).isEqualTo(new BigDecimal(String.valueOf(expected)).stripTrailingZeros());
    }

    @DisplayName("계산기 파라미터 테스트 - String")
    @ParameterizedTest
    @MethodSource("validStringInput")
    void 계산기_파라미터_테스트_String(String a, String b, OperatorType operatorType, String expected) {
        // Given

        // When
        BigDecimal actual = arithmeticCalculator.calculate(a, b, operatorType);

        // Then
        // double -> BigDecimal 변환하면서 불필요한 0을 제거해줘야 함
        assertThat(actual).isEqualTo(new BigDecimal(String.valueOf(expected)).stripTrailingZeros());
    }

    static Stream<Arguments> validIntInput() {
        return Stream.of(
                arguments(1, 2, OperatorType.ADD, 3),
                arguments(5, 3, OperatorType.SUB, 2),
                arguments(4, 7, OperatorType.MUL, 28),
                arguments(10, 2, OperatorType.DIV, 5),
                arguments(-3, -6, OperatorType.ADD, -9),
                arguments(9, -2, OperatorType.SUB, 11),
                arguments(-4, 3, OperatorType.MUL, -12),
                arguments(8, -4, OperatorType.DIV, -2),
                arguments(0, 5, OperatorType.ADD, 5),
                arguments(7, 0, OperatorType.SUB, 7),
                arguments(0, 10, OperatorType.MUL, 0),
                arguments(10, 10, OperatorType.DIV, 1)
        );
    }

    static Stream<Arguments> validDoubleInput() {
        return Stream.of(
                arguments(1.5, 2.3, OperatorType.ADD, 3.8),
                arguments(5.75, 3.25, OperatorType.SUB, 2.5),
                arguments(4.1, 7.2, OperatorType.MUL, 29.52),
                arguments(10.8, 2.4, OperatorType.DIV, 4.5),
                arguments(-3.7, -6.2, OperatorType.ADD, -9.9),
                arguments(9.9, -2.1, OperatorType.SUB, 12),
                arguments(-4.5, 3.3, OperatorType.MUL, -14.85),
                arguments(8.4, -4.2, OperatorType.DIV, -2),
                arguments(0.0, 5.5, OperatorType.ADD, 5.5),
                arguments(7.3, 0.0, OperatorType.SUB, 7.3),
                arguments(0.0, 10.9, OperatorType.MUL, 0),
                arguments(10.2, 10.2, OperatorType.DIV, 1)
        );
    }

    static Stream<Arguments> validStringInput() {
        return Stream.of(
                arguments("1.5", "-2", OperatorType.MUL, "-3.0"),
                arguments("2", "3", OperatorType.ADD, "5"),
                arguments("-4.5", "2", OperatorType.MUL, "-9.0"),
                arguments("10", "2.5", OperatorType.DIV, "4.0"),
                arguments("7.8", "3", OperatorType.SUB, "4.8"),
                arguments("-10", "-2.5", OperatorType.ADD, "-12.5"),
                arguments("0", "4.2", OperatorType.MUL, "0"),
                arguments("8.5", "-2", OperatorType.DIV, "-4.25"),
                arguments("3", "0.5", OperatorType.MUL, "1.5"),
                arguments("-3.2", "5", OperatorType.ADD, "1.8"),
                arguments("7", "-2.2", OperatorType.SUB, "9.2"),
                arguments("10.4", "2", OperatorType.DIV, "5.2")
        );
    }

    @DisplayName("계산기 파라미터 테스트 - ArithmeticException 발생")
    @ParameterizedTest
    @MethodSource("invalidInput")
    void givenInvalidInputs_whenCalculating_thenThrowsException(double a, double b, OperatorType operatorType) {
        // Given

        // When & Then
        assertThrows(ArithmeticException.class, () -> arithmeticCalculator.calculate(a, b, operatorType));
    }

    static Stream<Arguments> invalidInput() {
        return Stream.of(
                Arguments.arguments("-1.2", "0", OperatorType.DIV),
                Arguments.arguments("10", "0", OperatorType.DIV)
        );
    }

}
