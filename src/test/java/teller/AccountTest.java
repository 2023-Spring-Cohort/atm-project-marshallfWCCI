package teller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void getAccountNumber() {
        assertEquals("1-2-3", (new Account("1-2-3", "Checking", 0).getAccountNumber()));
    }

    @Test
    void getAccountType() {
        assertEquals("Checking", (new Account("1-2-3", "Checking", 0).getAccountType()));
    }

    @Test
    void getAccountBalance() {
        assertEquals(0f, (new Account("1-2-3", "Checking", 0).getAccountBalance()));
    }

    @Test void canDeposit() {
        new Account("1-2-3", "Checking", 0).deposit(0);
    }

    @Test void depositWorks() {
        Account checking = new Account("1-2-3", "Checking", 0);
        checking.deposit(1);
        assertEquals(1,checking.getAccountBalance());

    }
}