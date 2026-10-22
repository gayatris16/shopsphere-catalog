import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // ---------- Steps 5 and 6: the shelf and the switch ----------
        List<Product> shelf = List.of(
                new PhysicalProduct("SKU-1", "Keyboard", new BigDecimal("89.99"), 1.2),
                new DigitalProduct("SKU-2", "Java Course", new BigDecimal("29.00")),
                new SubscriptionProduct("SKU-3", "Cloud Storage", new BigDecimal("9.99"))
        );

        for (Product p : shelf) {
            System.out.println(p.getName() + " ships for " + p.shippingCost());

            String label = switch (p) {
                case PhysicalProduct pp     -> "Ships, " + pp.getWeightKg() + " kg";
                case DigitalProduct dp      -> "Instant download";
                case SubscriptionProduct sp -> "Billed monthly";
            };
            System.out.println("  " + label);
        }

        // ---------- Step 7: cartTotal ----------
        System.out.println("Cart total: " + cartTotal(shelf));
        System.out.println("Empty cart: " + cartTotal(List.of()));

        // ---------- Step 8: bad data must be rejected ----------

        // 1. blank name
        try {
            new PhysicalProduct("SKU-1", "", new BigDecimal("10.00"), 1.0);
            System.out.println("BUG: this should not print");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        // 2. null name
        try {
            new PhysicalProduct("SKU-1", null, new BigDecimal("10.00"), 1.0);
            System.out.println("BUG: this should not print");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        // 3. null price
        try {
            new PhysicalProduct("SKU-1", "Keyboard", null, 1.0);
            System.out.println("BUG: this should not print");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        // 4. negative price
        try {
            new PhysicalProduct("SKU-1", "Keyboard", new BigDecimal("-5"), 1.0);
            System.out.println("BUG: this should not print");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        // 5. blank sku
        try {
            new PhysicalProduct(" ", "Keyboard", new BigDecimal("10.00"), 1.0);
            System.out.println("BUG: this should not print");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        // 6. zero weight
        try {
            new PhysicalProduct("SKU-1", "Keyboard", new BigDecimal("10.00"), 0);
            System.out.println("BUG: this should not print");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }

    // start at zero, add each product's total cost, return the result
    static BigDecimal cartTotal(List<Product> items) {
        BigDecimal total = BigDecimal.ZERO;
        for (Product p : items) {
            total = total.add(p.totalCost());   // add() returns a NEW value, so we keep it
        }
        return total;
    }
}