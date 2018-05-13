package com.github.funthomas424242.examples.gauth;

/*-
 * #%L
 * gauth.example
 * %%
 * Copyright (C) 2018 PIUG
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsoleAuthenticationTest {


    @Test
    public void anmeldungZugriffVerweigert() {


        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        // ein definitiv unglültiger Kode, da zu lang (zumindest für den aktuellen GoogleAuthenticator in 2018).
        final byte[] passCode = "12343434".getBytes();
        final ByteArrayInputStream inStream = new ByteArrayInputStream(passCode);
        System.setIn(inStream);

        final ConsoleAuthentication authExample = new ConsoleAuthentication();
        authExample.run();

        assertTrue(baos.toString().contains("Zugang verweigert!"));
    }

}
