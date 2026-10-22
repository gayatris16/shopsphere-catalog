import java.math.BigDecimal;

public final class SubscriptionProduct extends Product{
    SubscriptionProduct(String sku, String name, BigDecimal price) {
        super(sku, name, price);
    }

    @Override
    public BigDecimal shippingCost() {
        return BigDecimal.ZERO;
    }
}
