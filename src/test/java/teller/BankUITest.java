package teller;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BankUITest {
    @Test
    void testExit() {
        final Bank bank = new Bank();
        bank.populateWithTestAccount();
        final Scanner input = new Scanner("0\n");

        final ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        final BankUI ui = new BankUI(bank, input, new PrintStream(bytes));

        assertEquals("", bytes.toString());
    }

}