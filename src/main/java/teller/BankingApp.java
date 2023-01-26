package teller;

import java.io.PrintStream;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        final Bank bank = new Bank();
        bank.openNewAccount(new Account("123-456", "Checking", 100));
        bank.openNewAccount(new Account("654-321", "Savings", 1000));

        final Scanner input = new Scanner(System.in);
        final PrintStream output = System.out;

        final BankUI bankUI = new BankUI(bank, input, output);
        bankUI.runUntilDone();
    }
}
