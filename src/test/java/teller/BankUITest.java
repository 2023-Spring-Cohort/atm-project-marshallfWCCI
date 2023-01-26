package teller;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BankUITest {
    @Test
    void testExit() {
        runScenario("0\n", BankUI.HELP_MSG + BankUI.BYE);
    }

    private static void runScenario(String source, String expected) {
        final Bank bank = new Bank();
        bank.populateWithTestAccount();
        final Scanner input = new Scanner(source);

        final ByteArrayOutputStream outputBytes = new ByteArrayOutputStream();
        new BankUI(bank, input, new PrintStream(outputBytes)).runUntilDone();

        assertEquals(expected, outputBytes.toString());
    }

}