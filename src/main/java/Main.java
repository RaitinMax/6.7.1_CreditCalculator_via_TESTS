import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Calculator calculator = new Calculator();
            System.out.println("Введите срок кредита (в годах)");
            BigDecimal years = scanner.nextBigDecimal();
            System.out.println("Введите сумму кредита");
            BigDecimal sum = scanner.nextBigDecimal();
            System.out.println("Введите процентную ставку");
            BigDecimal precent = scanner.nextBigDecimal();
            System.out.println("Ежемесячный платёж: " + calculator.monthPay(years, sum, precent));
            System.out.println("Всего выплатить банку " + calculator.allSum(years, sum, precent));
            System.out.println("Переплата: " + calculator.overPay(years, sum, precent));
        } catch (InputMismatchException e) {
            System.out.println("Введено не число!");
        }
    }
}
