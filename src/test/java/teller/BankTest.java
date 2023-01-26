package teller;

import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    void getAllAccounts() {
        for (Account account: new Bank().getAllAccounts()) {
            System.out.println(account);
        }
    }

    @Test
    void openNewAccount() {
        new Bank().openNewAccount(new Account("123-456", "Checking", 0));
    }
}
