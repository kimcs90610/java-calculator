import domain.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("단위 연산 수행 메서트 테스트")
    @ParameterizedTest
    @CsvSource(value = {"6 + 4 10", "6 - 4 2", "6 * 4 24", "6 / 4 1"}, delimiter = ' ')
    void calculateTest(int firstNumber, String operator, int secondNumber, int expected) {
        assertThat(Operator.calculate(firstNumber, operator, secondNumber)).isEqualTo(expected);
    }

    @Test
    void calculateExceptionTest() {
        assertThatThrownBy(()->Operator.calculate(1, "3", 2)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "6 + 4 + 10 + 2 + 3")
    void calculateTest2(String param) {
        List<String> list = Arrays.asList(param.split(" "));

//        int a = Operator.calculate(Integer.parseInt(list.get(0)), list.get(1), Integer.parseInt(list.get(2)));
//        int b = Operator.calculate(a, list.get(3), Integer.parseInt(list.get(4)));
//        int c = Operator.calculate(b, list.get(5), Integer.parseInt(list.get(6)));
//        int d = Operator.calculate(c, list.get(7), Integer.parseInt(list.get(8)));

        int sum = Operator.calculate(Integer.parseInt(list.get(0)), list.get(1), Integer.parseInt(list.get(2)));
        for (int i = 1; i < list.size()/2; i++) {
            sum = Operator.calculate(sum, list.get(2*i+1), Integer.parseInt(list.get(2*i+2)));
        }

        assertThat(sum).isEqualTo(25);
    }
}
