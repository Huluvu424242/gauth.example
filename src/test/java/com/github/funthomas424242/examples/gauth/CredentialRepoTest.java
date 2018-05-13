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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CredentialRepoTest {


    /**
     * Bitte den Test nicht als Vorbild nehmen - er ist Quark.
     */
    @Test
    public void anmeldungVerweigertTotalSimple() {

        final String userName = "Test";
        final GoogleAuthenticator gAuth = new GoogleAuthenticator();
        final GoogleAuthenticatorKey key = gAuth.createCredentials(userName);
        final String seed = key.getKey();


        final int code = GAuthClient.getCode(seed);
        boolean isCodeValid = gAuth.authorizeUser(userName, code);
        assertTrue(isCodeValid);




    }
}
