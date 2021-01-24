import domain.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("단위 연산 수행 메서트 테스트")
    @ParameterizedTest
    @CsvSource(value = {"6 + 4 10", "6 - 4 2", "6 * 4 24", "6 / 4 1"}, delimiter = ' ')
    void calculateTest(int firstNumber, String operator, int secondNumber, int expected) throws Exception {
        assertThat(Operator.calculate(firstNumber, operator, secondNumber)).isEqualTo(expected);
    }

    @Test
    void calculateExceptionTest() {
        assertThatThrownBy(()->Operator.calculate(1, "3", 2)).isInstanceOf(IllegalArgumentException.class);
    }
}
