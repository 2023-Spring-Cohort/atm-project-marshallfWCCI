package teller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountBuilderTest {
    @Test public void testSignature() {
        final AccountBuilder builder = new AccountBuilder();
        final Account account = builder.build();
    }

}