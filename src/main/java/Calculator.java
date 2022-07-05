import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
public class Calculator implements Calculating {

    public static final BigDecimal MONTHS_IN_YEAR = new BigDecimal(12);
    public static final BigDecimal PRECENTS = new BigDecimal(100);

    @Override
    public BigDecimal monthPay(BigDecimal years, BigDecimal sum, BigDecimal precent) {
        return allSum(years, sum, precent).divide(MONTHS_IN_YEAR.multiply(years), MathContext.DECIMAL32).setScale(2, RoundingMode.DOWN);
    }

    @Override
    public BigDecimal allSum(BigDecimal years, BigDecimal sum, BigDecimal precent) {
        return sum.add(overPay(years, sum, precent)).setScale(2, RoundingMode.DOWN);
    }

    @Override
    public BigDecimal overPay(BigDecimal years, BigDecimal sum, BigDecimal precent) {
        return sum.divide(PRECENTS).multiply(precent.multiply(years)).setScale(2, RoundingMode.DOWN);
    }
}
