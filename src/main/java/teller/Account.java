package teller;

public class Account {
    private final String accountNumber;
    private final String accountType;
    private final double accountBalance;

    public Account(String accountNumber, String accountType, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }
}
