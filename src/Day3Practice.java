public class Day3Practice {
    public static void main(String[] args) {
        System.out.println(new Customer("Asha", "asha@example.com", false));
        System.out.println(new Customer("Ravi", "ravi@example.com", true));
        try {
            new Customer(" ", "bad", false);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }


        // TODO 4: copy the try/catch above, but use a VALID name and the email "no-at-sign"

        System.out.println(ShippingCalculator.shippingTier(1200));
        System.out.println(ShippingCalculator.shippingTier(7000));
        System.out.println(ShippingCalculator.shippingTier(new java.math.BigDecimal("499.99")));
        System.out.println(ShippingCalculator.shippingTier(new java.math.BigDecimal("500.00")));
        System.out.println(ShippingCalculator.shippingTier(new java.math.BigDecimal("500.0")));

        try {
            ShippingCalculator.shippingTier(-5);
            System.out.println("BUG: this should not print");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}