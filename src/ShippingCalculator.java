import java.math.BigDecimal;

public class ShippingCalculator {

    // static final = one shared constant for the whole class, never changes.
    // Naming convention: UPPER_SNAKE_CASE.
    public static final int HEAVY_THRESHOLD_GRAMS = 5_000;
    public static final BigDecimal FREE_SHIPPING_THRESHOLD = new BigDecimal("500.00");

    // Overload 1: decide the tier from weight
    public static String shippingTier(int weightInGrams) {
        // TODO 1: if weightInGrams <= 0 -> throw new IllegalArgumentException("weight must be positive: " + weightInGrams)
        // TODO 2: return "HEAVY" if weightInGrams >= HEAVY_THRESHOLD_GRAMS, otherwise "STANDARD"
        if(weightInGrams <= 0){
            throw new IllegalArgumentException("weight must be positive: "+ weightInGrams);
        }
        return (weightInGrams>=HEAVY_THRESHOLD_GRAMS) ? "HEAVY" : "STANDARD";
    }

    // Overload 2: same name, different parameter type -> decide from order total
    public static String shippingTier(BigDecimal orderTotal) {
        // TODO 3: if orderTotal is null or negative -> throw new IllegalArgumentException("order total looks invalid: " + orderTotal)
        // TODO 4: return "FREE" if orderTotal >= FREE_SHIPPING_THRESHOLD, otherwise "PAID"
        if(orderTotal== null || orderTotal.compareTo(BigDecimal.ZERO)<0) {
            throw new IllegalArgumentException("Order total looks invalid: "+ orderTotal);
        }
        return (orderTotal.compareTo(FREE_SHIPPING_THRESHOLD)>=0)? "FREE" : "PAID";
    }
}