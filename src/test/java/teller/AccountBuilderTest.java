package teller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Note: builders are usually inlined, so we test that way
class AccountBuilderTest {
    @Test public void testSignature() {
        final Account account = new Account.AccountBuilder().build();
    }

    @Test public void testDefaultBalance() {
        final Account account = new Account.AccountBuilder().build();
        assertEquals(0, account.getAccountBalance());
    }
    @Test public void testDefaultNumber() {
        final Account account = new Account.AccountBuilder().build();
        assertEquals("", account.getAccountNumber());
    }
    @Test public void testDefaultType() {
        final Account account = new Account.AccountBuilder().build();
        assertEquals("checking", account.getAccountType());
    }
    @Test public void testSavingsType() {
        final Account account = new Account.AccountBuilder().withType("savings").build();
        assertEquals("savings", account.getAccountType());
    }
    @Test public void testAccountNumber() {
        final Account account = new Account.AccountBuilder().withAccountNumber("555-1234").build();
        assertEquals("555-1234", account.getAccountNumber());
    }
    @Test public void testBalance() {
        final Account account = new Account.AccountBuilder().withBalance(500).build();
        assertEquals(500, account.getAccountBalance());
    }
    @Test public void testAll() {
        final Account account = new Account.AccountBuilder().withType("special").withAccountNumber("555-5555").withBalance(1000.5).build();
        assertEquals("555-5555", account.getAccountNumber());
        assertEquals("special", account.getAccountType());
        assertEquals(1000.5, account.getAccountBalance());
    }
    @Test public void testAnotherOrder() {
        final Account account = new Account.AccountBuilder() //
                .withAccountNumber("555-5555") //
                .withType("special") //
                .withBalance(1000.5) //
                .build();
        assertEquals("555-5555", account.getAccountNumber());
        assertEquals("special", account.getAccountType());
        assertEquals(1000.5, account.getAccountBalance());
    }
}