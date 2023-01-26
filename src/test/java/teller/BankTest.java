package teller;

import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    void getAllAccounts() {
        for (Account account: new Bank().getAllAccounts()) {
            System.out.println(account);
        }
    }
}
