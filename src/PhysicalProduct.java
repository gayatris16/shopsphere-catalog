import java.math.BigDecimal;

public class PhysicalProduct extends Product{
    private final double weightKg;
    public PhysicalProduct(String sku, String name, BigDecimal price, double weightKg) {
        super(sku, name, price);
        this.weightKg=weightKg;
    }
    public double getWeightKg(){return weightKg; }

    @Override
    public BigDecimal shippingCost() {
        return null;
    }
}
