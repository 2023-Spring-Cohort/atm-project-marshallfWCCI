package teller;

import java.io.PrintStream;
import java.util.Scanner;

public class BankUI {
    private final Bank bank;
    private final Scanner input;
    private final PrintStream output;

    public static final String HELP_MSG = "\n\nPress 1 to deposit\nPress 2 to withdrawal\nPress 3 to check balance\nPress 4 to close an account\nPress 0 to exit\n";
    public static final String DEPOSIT = "You want to deposit\n";
    public static final String HERE_ARE_YOUR_ACCOUNTS = "Here are your accounts\n";
    public static final String ENTER_ACCOUNT = "Type the account number to choose an account to deposit to.\n";
    public static final String ENTER_DEPOSIT_AMOUNT = "Enter the amount to deposit.\n";
    public static final String YOU_HAVE_SELECTED = "You have selected account: ";
    public static final String YOU_HAVE_SELECTED_SUFFIX = "\n";
    public static final String YOU_DEPOSITED = "You deposited: ";
    public static final String YOU_DEPOSITED_SUFFIX = "\n";
    public static final String UPDATED_BALANCE = "Your updated balance is now: ";
    public static final String UPDATED_BALANCE_SUFFIX = "\n";
    public static final String NEXT = "What would you like to do next?";
    public static final String CLOSING = "You are closing account: ";
    public static final String CLOSING_SUFFIX = "\nHere are your remaining accounts\n";
    public static final String BYE = "Goodbye ... please come again!\n";

    public BankUI(Bank bank, Scanner input, PrintStream output) {
        this.bank = bank;
        this.input = input;
        this.output = output;
    }

    public void runUntilDone() {
        output.print(HERE_ARE_YOUR_ACCOUNTS);
        displayAccounts();
        int command = 0;
        do {
            output.print(HELP_MSG);
            command = input.nextByte();
            switch (command) {
                case 1:
                    output.print(DEPOSIT);
                    output.print(HERE_ARE_YOUR_ACCOUNTS);
                    displayAccounts();
                    output.print(ENTER_ACCOUNT);
                    final String accountNumber = input.next();
                    output.print(YOU_HAVE_SELECTED + accountNumber + YOU_HAVE_SELECTED_SUFFIX);
                    output.print(ENTER_DEPOSIT_AMOUNT);
                    final double amt = input.nextDouble();
                    bank.getAccount(accountNumber).deposit(amt);
                    output.print(YOU_DEPOSITED + amt + YOU_DEPOSITED_SUFFIX);
                    output.print(UPDATED_BALANCE + bank.getAccount(accountNumber).getAccountBalance() + UPDATED_BALANCE_SUFFIX);
                    output.print(NEXT);
            }
        } while (command != 0);

        output.print(BYE);
    }

    private void displayAccounts() {
        for (final Account account : bank.getAllAccounts()) {
            output.print("(" + account.getAccountNumber() + ") " + account.getAccountType() + " " + account.getAccountBalance() + "\n");
        }
    }
}
