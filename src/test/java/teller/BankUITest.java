package teller;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BankUITest {
    @Test
    void testExit() {
        runScenario("0\n", //
                BankUI.HERE_ARE_YOUR_ACCOUNTS +  //
                "(" + Bank.TEST_ACCOUNT_NUMBER1 + ") " + Bank.TEST_ACCOUNT_TYPE1 + " " + Bank.TEST_ACCOUNT_BALANCE1 + "\n" + //
                "(" + Bank.TEST_ACCOUNT_NUMBER2 + ") " + Bank.TEST_ACCOUNT_TYPE2 + " " + Bank.TEST_ACCOUNT_BALANCE2 + "\n" + //
                BankUI.HELP_MSG + BankUI.BYE);
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