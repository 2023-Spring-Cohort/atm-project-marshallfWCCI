package teller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void getAccountNumber() {
        assertEquals("1-2-3",
                new Account.Builder().withAccountNumber("1-2-3").withType("Checking").build()
                        .getAccountNumber());
    }

    @Test
    void getAccountType() {
        assertEquals("Checking",
        new Account.Builder().withAccountNumber("1-2-3").withType("Checking").build()
                        .getAccountType());
    }

    @Test
    void getAccountBalance() {
        assertEquals(0f,
        new Account.Builder().withAccountNumber("1-2-3").withType("Checking").build()
                        .getAccountBalance());
    }

    @Test
    void canDeposit() {
        new Account.Builder().withAccountNumber("1-2-3").withType("Checking").build()
                .deposit(0);
    }

    @Test
    void depositWorks() {
        Account checking =
        new Account.Builder().withAccountNumber("1-2-3").withType("Checking").build();
        checking.deposit(1);
        assertEquals(1, checking.getAccountBalance());
    }

    @Test
    void depositAdds() {
        Account checking =
        new Account.Builder().withAccountNumber("1-2-3").withType("Checking").withBalance(100).build();
        checking.deposit(1);
        assertEquals(101, checking.getAccountBalance());
    }

    @Test
    void canWithdraw() {
        new Account.Builder().withAccountNumber("1-2-3").withType("Checking").build()
                .withdraw(0);
    }

    @Test
    void withdrawWorks() {
        Account checking =
        new Account.Builder().withAccountNumber("1-2-3").withType("Checking").withBalance(100).build()
                ;
        checking.withdraw(1);
        assertEquals(99, checking.getAccountBalance());
    }
}