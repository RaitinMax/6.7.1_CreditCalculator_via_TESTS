import java.math.BigDecimal;

public interface Calculating {
    public BigDecimal monthPay(BigDecimal years, BigDecimal sum, BigDecimal precent);

    public BigDecimal allSum(BigDecimal years, BigDecimal sum, BigDecimal precent);

    public BigDecimal overPay(BigDecimal years, BigDecimal sum, BigDecimal precent);

}
