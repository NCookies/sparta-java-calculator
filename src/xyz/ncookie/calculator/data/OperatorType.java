package xyz.ncookie.calculator.data;

import java.util.Arrays;

public enum OperatorType {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    private final String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public static OperatorType getOperator(String s) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(s))
                .findFirst()
                .orElse(null);
    }
}
