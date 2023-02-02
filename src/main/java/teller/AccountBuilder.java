package teller;

// Fluent interface for constructing Account instances
public class AccountBuilder {
    private String type = "checking";
    private String accountNumber = "";
    private double balance = 0;

    public Account build() {
        return new Account(accountNumber, type, balance);
    }

    public AccountBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public AccountBuilder withAccountNumber(String s) {
        this.accountNumber = s;
        return this;
    }

    public AccountBuilder withBalance(double balance) {
        this.balance = balance;
        return this;
    }
}
