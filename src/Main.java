import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Declared as the parent type, so this list can hold any kind of Product
            List<Product> shelf = List.of(
                    new PhysicalProduct("SKU-1", "Keyboard", new BigDecimal("89.99"), 1.2),
                    new DigitalProduct("SKU-2", "Java Course", new BigDecimal("29.00"))
            );

            for (Product p : shelf) {
                System.out.println(p.getName() + " ships for " + p.shippingCost());
            }
        }catch (Exception e){
            System.out.println("REJECTED: "+ e.getMessage());
        }

    }
}