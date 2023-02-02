package teller;

public class Account {
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    private final String accountNumber;
    private final String accountType;
    private double accountBalance;

    private Account(String accountNumber, String accountType, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    public void deposit(double amount) {
        this.accountBalance += amount;
    }

    public void withdraw(double amount) {
        this.accountBalance -= amount;
    }

    // Fluent interface for constructing Account instances
    public static class Builder {
        private String type = "checking";
        private String accountNumber = "";
        private double balance = 0;

        public Account build() {
            return new Account(accountNumber, type, balance);
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withAccountNumber(String s) {
            this.accountNumber = s;
            return this;
        }

        public Builder withBalance(double balance) {
            this.balance = balance;
            return this;
        }
    }
}
