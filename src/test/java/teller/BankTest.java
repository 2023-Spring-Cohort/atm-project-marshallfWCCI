package teller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {
    @Test
    void getAllAccounts() {
        for (Account account: new Bank().getAllAccounts()) {
            System.out.println(account);
        }
    }

    @Test
    void openNewAccount() {
        new Bank().openNewAccount(new Account.Builder() //
               .withAccountNumber("123-456") //
                .withType("Checking") //
                .build());
    }

    @Test
    void getAccount() {
       Bank bank = new Bank();
       Account account = new Account.Builder().withAccountNumber("123-456").withType("Checking").build();
       bank.openNewAccount(account);
       assertEquals(account, bank.getAccount(account.getAccountNumber()));
    }

    @Test
    void closeAccount() {
        Bank bank = new Bank();
        Account account = new Account.Builder().withAccountNumber("123-456").withType("Checking").build();
        bank.openNewAccount(account);
        bank.closeAccount(account.getAccountNumber());
        assertEquals(null, bank.getAccount("123-456"));
    }

    @Test
    void closeJustOneAccount() {
        Bank bank = new Bank();
        Account account1 = new Account.Builder().withAccountNumber("123-456").withType("Checking").build();
        Account account2 = new Account.Builder().withAccountNumber("456-123").withType("Checking").build();
        bank.openNewAccount(account1);
        bank.openNewAccount(account2);
        bank.closeAccount(account1.getAccountNumber());
        assertEquals(account2, bank.getAccount(account2.getAccountNumber()));
    }

    @Test
    void closeSecondAccount() {
        Bank bank = new Bank();
        Account account1 = new Account.Builder().withAccountNumber("123-456").withType("Checking").build();
        Account account2 = new Account.Builder().withAccountNumber("456-123").withType("Checking").build();
        bank.openNewAccount(account1);
        bank.openNewAccount(account2);
        bank.closeAccount(account2.getAccountNumber());
        assertEquals(account1, bank.getAccount(account1.getAccountNumber()));
    }

}