import java.math.BigDecimal;
import java.util.Objects;

// 'sealed' = only the listed subclasses may extend this. The compiler then knows
// every possible product type, which enables safe, exhaustive switch statements.
public abstract sealed class Product permits DigitalProduct, PhysicalProduct, SubscriptionProduct {

    // private + final: the identity can never change or be touched from outside (encapsulation)
    private final String sku;
    private final String name;
    private BigDecimal price; // BigDecimal, never double, for money

    protected Product(String sku, String name, BigDecimal price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        if(price == null || price.signum()<0){
            throw new IllegalArgumentException("Price should be Whole number");
        }
        this.sku = requireText(sku, "sku");
        this.name = requireText(name, "name");
        setPrice(price); // reuse the validation in one place
    }

    public void setPrice(BigDecimal price) {
        Objects.requireNonNull(price, "price must not be null");
        if (price.signum() < 0) {
            throw new IllegalArgumentException("price must not be negative");
        }
        this.price = price;
    }

    // Abstraction: every product must say how it ships, but each decides how
    public abstract BigDecimal shippingCost();

    // Shared behavior lives here once (inheritance gives subclasses this for free)
    public BigDecimal totalCost() {
        return price.add(shippingCost());
    }

    public String getSku()  { return sku; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }

    private static String requireText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " must not be blank");
        }
        return value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[sku=" + sku + ", name=" + name + ", price=" + price + "]";
    }
}