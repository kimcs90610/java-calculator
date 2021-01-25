package domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVISION("/", (a, b) -> (a / b));

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static int calculate(int firstNumber, String operator, int secondNumber) {
        return findOperator(operator).expression.apply(firstNumber, secondNumber);
    }

    public static Operator findOperator(String operator) {
        return Arrays.stream(values())
                .filter(enumValue -> enumValue.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 연산자를 입력해주세요."));
    }

}
