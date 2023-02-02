package teller;

// Fluent interface for constructing Account instances
public class AccountBuilder {
    private String type = "checking";

    public Account build() {
        return new Account("", type, 0);
    }

    public AccountBuilder withType(String type) {
        this.type = type;
        return this;
    }
}
