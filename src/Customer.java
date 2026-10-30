public class Customer {
    private final String name;
    private final String email;
    private final boolean premium;

    // MAIN constructor: all the validation lives here
    public Customer(String name, String email, boolean premium) {
        // TODO 1: if name is null or blank -> throw new IllegalArgumentException("name must not be blank")
        // TODO 2: if email is null or does not contain "@" -> throw new IllegalArgumentException("email looks invalid: " + email)
        if(name.isBlank() || name.equals(" ")){
            throw new IllegalArgumentException("Name must not be blank ");
        }
        if(email.isBlank() || !email.contains("@")){
            throw new IllegalArgumentException("Email provided is invalid ");
        }
        this.name = name;
        this.email = email;
        this.premium = premium;
    }

    // CONVENIENCE constructor: premium defaults to false
    public Customer(String name, String email, String name1, String email1, boolean premium) {
        // TODO 3: hand off to the main constructor, with premium = false
        this(name, email, false);
    }

    @Override
    public String toString() {
        return name + " <" + email + ">" + (premium ? " [premium]" : "");
    }
}