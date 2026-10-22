import java.math.BigDecimal;

public class MoneyBug {
    public static void main(String[] args) {

        // the buggy way: double
        double wrong = 0;
        for (int i = 0; i < 10; i++) {
            wrong = wrong + 0.10;
        }
        System.out.println("double:     " + wrong);

        // the correct way: BigDecimal built from a String
        BigDecimal right = BigDecimal.ZERO;
        for (int i = 0; i < 10; i++) {
            right = right.add(new BigDecimal("0.10"));
        }
        System.out.println("BigDecimal: " + right);
    }
}