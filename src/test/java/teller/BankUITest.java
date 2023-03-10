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
                        BankUI.HELP_MSG + //
                        BankUI.BYE);
    }

    @Test
    void testBadCommand() {
        runScenario("Hello\n0\n",
                BankUI.HERE_ARE_YOUR_ACCOUNTS +  //
                        "(" + Bank.TEST_ACCOUNT_NUMBER1 + ") " + Bank.TEST_ACCOUNT_TYPE1 + " " + Bank.TEST_ACCOUNT_BALANCE1 + "\n" + //
                        "(" + Bank.TEST_ACCOUNT_NUMBER2 + ") " + Bank.TEST_ACCOUNT_TYPE2 + " " + Bank.TEST_ACCOUNT_BALANCE2 + "\n" + //
                        BankUI.HELP_MSG +  //
                        BankUI.PLEASE_ENTER_A_NUMBER_RATHER_THAN + "Hello" + BankUI.PLEASE_ENTER_A_NUMBER_RATHER_THAN_SUFFIX + //
                        BankUI.BYE);
    }

    @Test
    void testUnexpected() {
        runScenario("5\n0\n",
                BankUI.HERE_ARE_YOUR_ACCOUNTS +  //
                        "(" + Bank.TEST_ACCOUNT_NUMBER1 + ") " + Bank.TEST_ACCOUNT_TYPE1 + " " + Bank.TEST_ACCOUNT_BALANCE1 + "\n" + //
                        "(" + Bank.TEST_ACCOUNT_NUMBER2 + ") " + Bank.TEST_ACCOUNT_TYPE2 + " " + Bank.TEST_ACCOUNT_BALANCE2 + "\n" + //
                        BankUI.HELP_MSG +  //
                        BankUI.UNEXPECTED_COMMAND + //
                        BankUI.HELP_MSG +  //
                        BankUI.BYE);
    }

    @Test
    void testDeposit() {
        runScenario("1\n" + //
                        Bank.TEST_ACCOUNT_NUMBER1 + "\n" + //
                        500.0 + "\n" + //
                        "0\n", //
                BankUI.HERE_ARE_YOUR_ACCOUNTS +  //
                        "(" + Bank.TEST_ACCOUNT_NUMBER1 + ") " + Bank.TEST_ACCOUNT_TYPE1 + " " + Bank.TEST_ACCOUNT_BALANCE1 + "\n" + //
                        "(" + Bank.TEST_ACCOUNT_NUMBER2 + ") " + Bank.TEST_ACCOUNT_TYPE2 + " " + Bank.TEST_ACCOUNT_BALANCE2 + "\n" + //
                        BankUI.HELP_MSG + //
                        BankUI.DEPOSIT + //
                        BankUI.HERE_ARE_YOUR_ACCOUNTS + //
                        "(" + Bank.TEST_ACCOUNT_NUMBER1 + ") " + Bank.TEST_ACCOUNT_TYPE1 + " " + Bank.TEST_ACCOUNT_BALANCE1 + "\n" + //
                        "(" + Bank.TEST_ACCOUNT_NUMBER2 + ") " + Bank.TEST_ACCOUNT_TYPE2 + " " + Bank.TEST_ACCOUNT_BALANCE2 + "\n" + //
                        BankUI.ENTER_ACCOUNT + //
                        BankUI.YOU_HAVE_SELECTED + Bank.TEST_ACCOUNT_NUMBER1 + BankUI.YOU_HAVE_SELECTED_SUFFIX + //
                        BankUI.ENTER_DEPOSIT_AMOUNT + //
                        BankUI.YOU_DEPOSITED + 500.0 + BankUI.YOU_DEPOSITED_SUFFIX + //
                        BankUI.UPDATED_BALANCE + (Bank.TEST_ACCOUNT_BALANCE1 + 500) + BankUI.UPDATED_BALANCE_SUFFIX + //
                        BankUI.NEXT + //
                        BankUI.HELP_MSG +  //
                        BankUI.BYE);
    }

    @Test
    void testWithdrawl() {
        runScenario("2\n" + //
                        Bank.TEST_ACCOUNT_NUMBER1 + "\n" + //
                        500.0 + "\n" + //
                        "0\n", //
                BankUI.HERE_ARE_YOUR_ACCOUNTS +  //
                        "(" + Bank.TEST_ACCOUNT_NUMBER1 + ") " + Bank.TEST_ACCOUNT_TYPE1 + " " + Bank.TEST_ACCOUNT_BALANCE1 + "\n" + //
                        "(" + Bank.TEST_ACCOUNT_NUMBER2 + ") " + Bank.TEST_ACCOUNT_TYPE2 + " " + Bank.TEST_ACCOUNT_BALANCE2 + "\n" + //
                        BankUI.HELP_MSG + //
                        BankUI.WITHDRAW + //
                        BankUI.HERE_ARE_YOUR_ACCOUNTS + //
                        "(" + Bank.TEST_ACCOUNT_NUMBER1 + ") " + Bank.TEST_ACCOUNT_TYPE1 + " " + Bank.TEST_ACCOUNT_BALANCE1 + "\n" + //
                        "(" + Bank.TEST_ACCOUNT_NUMBER2 + ") " + Bank.TEST_ACCOUNT_TYPE2 + " " + Bank.TEST_ACCOUNT_BALANCE2 + "\n" + //
                        BankUI.ENTER_ACCOUNT + //
                        BankUI.YOU_HAVE_SELECTED + Bank.TEST_ACCOUNT_NUMBER1 + BankUI.YOU_HAVE_SELECTED_SUFFIX + //
                        BankUI.ENTER_WITHDRAW_AMOUNT + //
                        BankUI.YOU_WITHDREW + 500.0 + BankUI.YOU_WITHDREW_SUFFIX + //
                        BankUI.UPDATED_BALANCE + (Bank.TEST_ACCOUNT_BALANCE1 - 500) + BankUI.UPDATED_BALANCE_SUFFIX + //
                        BankUI.NEXT + //
                        BankUI.HELP_MSG +  //
                        BankUI.BYE);
    }

    @Test
    void testClosing() {
        runScenario("4\n" + //
                        Bank.TEST_ACCOUNT_NUMBER1 + "\n" + //
                        "0\n", //
                BankUI.HERE_ARE_YOUR_ACCOUNTS +  //
                        "(" + Bank.TEST_ACCOUNT_NUMBER1 + ") " + Bank.TEST_ACCOUNT_TYPE1 + " " + Bank.TEST_ACCOUNT_BALANCE1 + "\n" + //
                        "(" + Bank.TEST_ACCOUNT_NUMBER2 + ") " + Bank.TEST_ACCOUNT_TYPE2 + " " + Bank.TEST_ACCOUNT_BALANCE2 + "\n" + //
                        BankUI.HELP_MSG + //
                        BankUI.CLOSE + //
                        BankUI.HERE_ARE_YOUR_ACCOUNTS + //
                        "(" + Bank.TEST_ACCOUNT_NUMBER1 + ") " + Bank.TEST_ACCOUNT_TYPE1 + " " + Bank.TEST_ACCOUNT_BALANCE1 + "\n" + //
                        "(" + Bank.TEST_ACCOUNT_NUMBER2 + ") " + Bank.TEST_ACCOUNT_TYPE2 + " " + Bank.TEST_ACCOUNT_BALANCE2 + "\n" + //
                        BankUI.ENTER_ACCOUNT + //
                        BankUI.YOU_HAVE_SELECTED + Bank.TEST_ACCOUNT_NUMBER1 + BankUI.YOU_HAVE_SELECTED_SUFFIX + //
                        BankUI.YOU_CLOSED + Bank.TEST_ACCOUNT_NUMBER1+ BankUI.YOU_CLOSED_SUFFIX + //
                        BankUI.HERE_ARE_YOUR_ACCOUNTS + //
                        "(" + Bank.TEST_ACCOUNT_NUMBER2 + ") " + Bank.TEST_ACCOUNT_TYPE2 + " " + Bank.TEST_ACCOUNT_BALANCE2 + "\n" + //
                        BankUI.NEXT + //
                        BankUI.HELP_MSG +  //
                        BankUI.BYE);
    }
    @Test
    void testShowBalances() {
        runScenario("3\n" + //
                        "0\n", //
                BankUI.HERE_ARE_YOUR_ACCOUNTS +  //
                        "(" + Bank.TEST_ACCOUNT_NUMBER1 + ") " + Bank.TEST_ACCOUNT_TYPE1 + " " + Bank.TEST_ACCOUNT_BALANCE1 + "\n" + //
                        "(" + Bank.TEST_ACCOUNT_NUMBER2 + ") " + Bank.TEST_ACCOUNT_TYPE2 + " " + Bank.TEST_ACCOUNT_BALANCE2 + "\n" + //
                        BankUI.HELP_MSG +  //
                        BankUI.HERE_ARE_YOUR_ACCOUNTS +  //
                        "(" + Bank.TEST_ACCOUNT_NUMBER1 + ") " + Bank.TEST_ACCOUNT_TYPE1 + " " + Bank.TEST_ACCOUNT_BALANCE1 + "\n" + //
                        "(" + Bank.TEST_ACCOUNT_NUMBER2 + ") " + Bank.TEST_ACCOUNT_TYPE2 + " " + Bank.TEST_ACCOUNT_BALANCE2 + "\n" + //
                        BankUI.NEXT + //
                        BankUI.HELP_MSG +  //
                        BankUI.BYE);
    }

    private static void runScenario(final String userCommands, final String expectedOutput) {
        final Bank bank = new Bank();
        bank.populateWithTestAccount();

        final Scanner input = new Scanner(userCommands);

        final ByteArrayOutputStream outputBytes = new ByteArrayOutputStream();
        final PrintStream output = new PrintStream(outputBytes);

        new BankUI(bank, input, output).runUntilDone();

        assertEquals(expectedOutput, outputBytes.toString());
    }

}