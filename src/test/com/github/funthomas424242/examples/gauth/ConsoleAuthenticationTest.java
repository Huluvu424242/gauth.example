package com.github.funthomas424242.examples.gauth;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsoleAuthenticationTest {

    /**
     * Bitte den Test nicht als Vorbild nehmen - er ist Quark.
     */
    @Test
    public void anmeldungVerweigertTotalSimple() {


        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        // ein definitiv unglültiger Kode, da zu lang (zumindest für den aktuellen GoogleAuthenticator in 2018).
        final byte[] passCode = "12343434".getBytes();
        final ByteArrayInputStream inStream = new ByteArrayInputStream(passCode);
        System.setIn(inStream);

        final ConsoleAuthentication authExample = new ConsoleAuthentication();
        authExample.main(null);

        assertTrue(baos.toString().contains("Zugang verweigert!"));
    }
}