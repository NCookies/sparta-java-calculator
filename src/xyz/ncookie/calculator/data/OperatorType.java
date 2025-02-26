package xyz.ncookie.calculator.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorType {
    ADD("+", BigDecimal::add),
    SUB("-", BigDecimal::subtract),
    MUL("*", BigDecimal::multiply),
    DIV("/", (a, b) ->
            a.divide(b, 10, RoundingMode.HALF_EVEN).stripTrailingZeros());

    private final String operator;
    private final BiFunction<BigDecimal, BigDecimal, BigDecimal> calculateFunc;

    OperatorType(String operator, BiFunction<BigDecimal, BigDecimal, BigDecimal> calculateFunc) {
        this.operator = operator;
        this.calculateFunc = calculateFunc;
    }

    public BigDecimal calculate(BigDecimal a, BigDecimal b) {
        return this.calculateFunc.apply(a, b);
    }

    public static OperatorType getOperator(String s) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(s))
                .findFirst()
                .orElse(null);
    }
}
