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

import com.google.auto.service.AutoService;
import com.warrenstrange.googleauth.ICredentialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@AutoService(ICredentialRepository.class)
public class CredentialRepo implements ICredentialRepository {

    protected final Logger LOGGER = LoggerFactory.getLogger(CredentialRepo.class);


    protected final HashMap<String, com.github.funthomas424242.examples.gauth.UserDataAccessor> username2UserDataAccessor = new HashMap<>();

    protected void logDebug(final String message) {
        LOGGER.debug("###: "+message);
    }


    @Override
    public String getSecretKey(final String userName) {
        final com.github.funthomas424242.examples.gauth.UserDataAccessor userData = username2UserDataAccessor.get(userName);
        final String secretKey= userData.getSecretKey();
        logDebug("Get Secret Key:"+secretKey+" für user: " + userName);
        return secretKey;
    }

    @Override
    public void saveUserCredentials(final String userName, final String secretKey, final int validationCode, final List<Integer> scratchCodes) {
        logDebug("Speichere für " + userName + " den Secret Key: " + secretKey);
        final com.github.funthomas424242.examples.gauth.UserDataAccessor userData
                = new com.github.funthomas424242.examples.gauth.UserDataBuilder()
                .withCode(validationCode)
                .withSecretKey(secretKey)
                .withScratchCodes(scratchCodes)
                .build(com.github.funthomas424242.examples.gauth.UserDataAccessor.class);
        username2UserDataAccessor.put(userName, userData);
    }


}
