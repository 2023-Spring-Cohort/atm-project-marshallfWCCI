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

        final ByteArrayOutputStream outputBytes = new ByteArrayOutputStream();
        new BankUI(bank, input, new PrintStream(outputBytes)).runUntilDone();

        assertEquals(BankUI.HELP_MSG + BankUI.BYE, outputBytes.toString());
    }

}