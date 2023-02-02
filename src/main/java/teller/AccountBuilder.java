package teller;

// Fluent interface for constructing Account instances
public class AccountBuilder {
    private String type = "checking";
    private String accountNumber = "";

    public Account build() {
        return new Account(accountNumber, type, 0);
    }

    public AccountBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public AccountBuilder withAccountNumber(String s) {
        this.accountNumber = s;
        return this;
    }
}
