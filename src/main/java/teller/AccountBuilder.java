package teller;

// Fluent interface for constructing Account instances
public class AccountBuilder {
    public Account build() {
        return new Account("", "checking", 0);
    }
}
