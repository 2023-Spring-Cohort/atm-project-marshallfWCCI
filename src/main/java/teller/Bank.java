package teller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    final private Map<String, Account> accounts = new HashMap<>();

    Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    public void openNewAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String id) {
        return accounts.get(id);
    }
}
