package teller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountBuilderTest {
    @Test public void testSignature() {
        final AccountBuilder builder = new AccountBuilder();
        final Account account = builder.build();
    }

    @Test public void testDefaultBalance() {
        final AccountBuilder builder = new AccountBuilder();
        final Account account = builder.build();
        assertEquals(0, account.getAccountBalance());
    }
    @Test public void testDefaultNumber() {
        final AccountBuilder builder = new AccountBuilder();
        final Account account = builder.build();
        assertEquals("", account.getAccountNumber());
    }
    @Test public void testDefaultType() {
        final AccountBuilder builder = new AccountBuilder();
        final Account account = builder.build();
        assertEquals("checking", account.getAccountType());
    }
    @Test public void testSavingsType() {
        final AccountBuilder builder = new AccountBuilder();
        final Account account = builder.withType("savings").build();
        assertEquals("savings", account.getAccountType());
    }
    @Test public void testAccountNumber() {
        final AccountBuilder builder = new AccountBuilder();
        final Account account = builder.withAccountNumber("555-1234").build();
        assertEquals("555-1234", account.getAccountNumber());
    }
    @Test public void testBalance() {
        final AccountBuilder builder = new AccountBuilder();
        final Account account = builder.withBalance(500).build();
        assertEquals(500, account.getAccountBalance());
    }
    @Test public void testAll() {
        final AccountBuilder builder = new AccountBuilder();
        final Account account = builder.withType("special").withAccountNumber("555-5555").withBalance(1000.5).build();
        assertEquals("555-5555", account.getAccountNumber());
        assertEquals("special", account.getAccountType());
        assertEquals(1000.5, account.getAccountBalance());
    }
    @Test public void testAnotherOrder() {
        final Account account = new AccountBuilder() //
                .withAccountNumber("555-5555") //
                .withType("special") //
                .withBalance(1000.5) //
                .build();
        assertEquals("555-5555", account.getAccountNumber());
        assertEquals("special", account.getAccountType());
        assertEquals(1000.5, account.getAccountBalance());
    }
}