import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Product> shelf = List.of(
                    new PhysicalProduct("SKU-1", "Keyboard", new BigDecimal("89.99"), 1.2),
                    new DigitalProduct("SKU-2", "Java Course", new BigDecimal("29.00")),
                    new SubscriptionProduct("SKU-3", "Cloud Storage", new BigDecimal("9.99"))
            );

            for (Product p : shelf) {
                System.out.println(p.getName() + " ships for " + p.shippingCost());

                String label = switch (p) {
                    case PhysicalProduct pp -> "Ships, " + pp.getWeightKg() + " kg";
                    case DigitalProduct dp  -> "Instant download";
                    case SubscriptionProduct sp -> "Billed monthly";
                };
                System.out.println("  " + label);
            }
        }catch (Exception e){
            System.out.println("REJECTED: "+ e.getMessage());
        }

    }
}