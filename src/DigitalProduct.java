import java.math.BigDecimal;

public final class DigitalProduct extends Product{
    DigitalProduct(String sku, String name, BigDecimal price) {
        super(sku, name, price);

    }

    @Override
    public BigDecimal shippingCost() {
        return BigDecimal.ZERO;
    }
}
