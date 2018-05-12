package com.github.funthomas424242.examples.gauth;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

import java.util.Scanner;

public class ConsoleAuthentication {


    public static void main(final String[] args) {
        final GoogleAuthenticator gAuth = new GoogleAuthenticator();
        final GoogleAuthenticatorKey key = gAuth.createCredentials();
        final String seed=key.getKey();

        System.out.println("Starten Sie nun ihre Google Authenticator App und fügen Sie folgendes Konto hinzu: 'Test'\n\n");
        System.out.println("Bitte notieren Sie folgenden Sicherheitsschlüssel und schützen Sie diesen vor dem Zugriff Anderer:\n");
        System.out.println(seed);
        System.out.println();
        System.out.println("Fügen Sie nun den Sicherheitsschlüssel im Google Authenticator obigem Konto hinzu.");
        System.out.println();
        System.out.println("Prüfen Sie Ihren Zugang indem Sie nun den generierten Code vom Google Authenticator eingeben und  mit Enter bestätigen.");

        Scanner s = new Scanner(System.in);
        final int code= s.nextInt();

        final boolean isValidCode = isCodeValid(seed, code);
        if( isValidCode ){
            System.out.println("Zugang gewährt!");
        }else{
            System.out.println("Zugang verweigert!");
        }
    }

    private static boolean isCodeValid(final String seed, final int code) {
        final GoogleAuthenticator gAuth = new GoogleAuthenticator();
        return gAuth.authorize(seed, code);
    }

}
