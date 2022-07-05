import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class CalculatorTest {

    public static Calculating calculate = new Calculator(); // Здесь будет экземпляр класса-реализации

    @ParameterizedTest
    @MethodSource("argumentsMonthPayTest")
    public void testMonthPay(BigDecimal years, BigDecimal sum, BigDecimal precent, BigDecimal result) {
        BigDecimal monthPay = calculate.monthPay(years, sum, precent);
        Assertions.assertEquals(result, monthPay);
    }

    @ParameterizedTest
    @MethodSource("argumentsAllSumTest")
    public void testAllSum(BigDecimal years, BigDecimal sum, BigDecimal precent, BigDecimal result) {
        BigDecimal allSum = calculate.allSum(years, sum, precent);
        Assertions.assertEquals(result, allSum);
    }

    @ParameterizedTest
    @MethodSource("argumentsOverPayTest")
    public void testOverPay(BigDecimal years, BigDecimal sum, BigDecimal precent, BigDecimal result) {
        BigDecimal overPay = calculate.overPay(years, sum, precent);
        Assertions.assertEquals(result, overPay);
    }

    public static Stream<Arguments> argumentsMonthPayTest() {
        return Stream.of(Arguments.of(new BigDecimal(1), new BigDecimal(10000), new BigDecimal(20), new BigDecimal("1000.00")),
                Arguments.of(new BigDecimal(1), new BigDecimal(5000), new BigDecimal(20), new BigDecimal("500.00")),
                Arguments.of(new BigDecimal(2), new BigDecimal(6000), new BigDecimal(10), new BigDecimal("300.00")),
                Arguments.of(new BigDecimal("0.5"), new BigDecimal(10000), new BigDecimal(40), new BigDecimal("2000.00")),
                Arguments.of(new BigDecimal(1), new BigDecimal(1000), new BigDecimal("12.5"), new BigDecimal("93.75")));
    }

    public static Stream<Arguments> argumentsAllSumTest() {
        return Stream.of(Arguments.of(new BigDecimal(1), new BigDecimal(10000), new BigDecimal(20), new BigDecimal("12000.00")),
                Arguments.of(new BigDecimal(1), new BigDecimal(5000), new BigDecimal(20), new BigDecimal("6000.00")),
                Arguments.of(new BigDecimal(2), new BigDecimal(6000), new BigDecimal(10), new BigDecimal("7200.00")),
                Arguments.of(new BigDecimal("0.5"), new BigDecimal(10000), new BigDecimal(40), new BigDecimal("12000.00")),
                Arguments.of(new BigDecimal(1), new BigDecimal(1000), new BigDecimal("12.5"), new BigDecimal("1125.00")));
    }

    public static Stream<Arguments> argumentsOverPayTest() {
        return Stream.of(Arguments.of(new BigDecimal(1), new BigDecimal(10000), new BigDecimal(20), new BigDecimal("2000.00")),
                Arguments.of(new BigDecimal(1), new BigDecimal(5000), new BigDecimal(20), new BigDecimal("1000.00")),
                Arguments.of(new BigDecimal(2), new BigDecimal(6000), new BigDecimal(10), new BigDecimal("1200.00")),
                Arguments.of(new BigDecimal("0.5"), new BigDecimal(10000), new BigDecimal(40), new BigDecimal("2000.00")),
                Arguments.of(new BigDecimal(1), new BigDecimal(1000), new BigDecimal("12.5"), new BigDecimal("125.00")));
    }
}
