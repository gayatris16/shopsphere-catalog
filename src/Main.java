import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Declared as the parent type, so this list can hold any kind of Product
        PhysicalProduct kb = new PhysicalProduct("SKU-2", " ", new BigDecimal("89.99"), 1.2);
        System.out.println(kb.getName() + " weighs " + kb.getWeightKg() + " kg");
    }
}