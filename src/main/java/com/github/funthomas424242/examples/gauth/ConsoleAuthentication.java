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

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

import java.util.Scanner;

public class ConsoleAuthentication {


    public static void main(final String[] args) {
        final GoogleAuthenticator gAuth = new GoogleAuthenticator();
        final GoogleAuthenticatorKey key = gAuth.createCredentials();
        final String seed = key.getKey();

        System.out.println("Starten Sie nun ihre Google Authenticator App und fügen Sie folgendes Konto hinzu: 'Test'\n\n");
        System.out.println("Bitte notieren Sie folgenden Sicherheitsschlüssel und schützen Sie diesen vor dem Zugriff Anderer:\n");
        System.out.println(seed);
        System.out.println();
        System.out.println("Fügen Sie nun den Sicherheitsschlüssel im Google Authenticator obigem Konto hinzu.");
        System.out.println();
        System.out.println("Prüfen Sie Ihren Zugang indem Sie nun den generierten Code vom Google Authenticator eingeben und  mit Enter bestätigen.");

        Scanner s = new Scanner(System.in);
        final int code = s.nextInt();

        final boolean isValidCode = isCodeValid(seed, code);
        if (isValidCode) {
            System.out.println("Zugang gewährt!");
        } else {
            System.out.println("Zugang verweigert!");
        }
    }

    private static boolean isCodeValid(final String seed, final int code) {
        final GoogleAuthenticator gAuth = new GoogleAuthenticator();
        return gAuth.authorize(seed, code);
    }

}
