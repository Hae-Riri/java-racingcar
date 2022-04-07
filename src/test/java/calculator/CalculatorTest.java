package calculator;

<<<<<<< HEAD
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
=======
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
>>>>>>> a80a2bb801c40c45a660a7e8d79fc3cde75d2215

class CalculatorTest {

    private Calculator calculator;

<<<<<<< HEAD
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 나눗셈_0으로_나눌_때() {
        String[] data = {"5", "/", "0"};
        assertThatIllegalArgumentException()
            .isThrownBy(() -> calculator.execute(data));
    }

    @Test
    void 덧셈() {
        String[] data = {"5", "+", "9"};
        Assertions.assertThat(calculator.execute(data)).isEqualTo(14);
    }

    @Test
    void 뺼셈_결과_음수() {
        String[] data = {"1", "-", "3"};
        Assertions.assertThat(calculator.execute(data)).isEqualTo(-2);
    }

    @Test
    void 곱셈() {
        String[] data = {"5", "*", "3"};
        Assertions.assertThat(calculator.execute(data)).isEqualTo(15);
    }

    @Test
    void 나눗셈_결과_2자리_이상() {
        String[] data = {"1", "/", "3"};
        double result = calculator.execute(data);
        Assertions.assertThat(result).isEqualTo(0.33);
    }
}
=======
    @Test
    void 나눗셈_0으로_나눌_때_애러() {
        calculator = new Calculator(
            new LinkedList(Arrays.asList("5", "0")),
            new LinkedList(Arrays.asList("/"))
        );

        assertThatIllegalArgumentException()
            .isThrownBy(() -> calculator.execute());
    }

    @Test
    void 나눗셈_결과가_소숫점_2자리가_맞는지_확인() {
        calculator = new Calculator(
            new LinkedList(Arrays.asList("1", "3")),
            new LinkedList(Arrays.asList("/"))
        );
        assertThat(hasTwoDecimalPoint(calculator.execute())).isTrue();
    }

    boolean hasTwoDecimalPoint(Double number) {
        double compare = number * Math.pow(10, 2);
        return compare == (int) compare;
    }

    @Test
    void 덧셈_정상() {
        calculator = new Calculator(
            new LinkedList(Arrays.asList("5", "2")),
            new LinkedList(Arrays.asList("+"))
        );
        assertThat(calculator.execute()).isEqualTo(7);
    }

    @Test
    void 뺼셈_정상() {
        calculator = new Calculator(
            new LinkedList(Arrays.asList("2", "5")),
            new LinkedList(Arrays.asList("-"))
        );
        assertThat(calculator.execute()).isEqualTo(-3);
    }

    @Test
    void 곱셈_정상() {
        calculator = new Calculator(
            new LinkedList(Arrays.asList("5", "2")),
            new LinkedList(Arrays.asList("*"))
        );
        assertThat(calculator.execute()).isEqualTo(10);
    }

    @Test
    void 연속연산_정상() {
        calculator = new Calculator(
            new LinkedList(Arrays.asList("12", "3", "4")),
            new LinkedList(Arrays.asList("+", "*"))
        );
        assertThat(calculator.execute()).isEqualTo(60);
    }
}
>>>>>>> a80a2bb801c40c45a660a7e8d79fc3cde75d2215
