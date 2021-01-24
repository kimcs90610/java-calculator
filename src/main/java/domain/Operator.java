package domain;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVISION("/", (a, b) -> (a / b));

    private static Operator finedOperator = null;
    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static int calculate(int firstNumber, String operator, int secondNumber) throws Exception {
        return findOperator(operator).expression.apply(firstNumber, secondNumber);
    }

    public static Operator findOperator(String operator) throws Exception {
        for (Operator enumObject : values()) {
            compareOperator(enumObject, operator);
        }
        if (finedOperator == null) {
            throw new IllegalArgumentException("연산자가 없습니다.");
        }

        return finedOperator;
/*        return Arrays.stream(values())
                .filter(enumValue -> enumValue.operator.equals(operator))
                .findFirst().get();*/
    }

    private static void compareOperator(Operator enumObject, String operator) {
        if (enumObject.operator.equals(operator)) {
            finedOperator = enumObject;
        }
    }

}
