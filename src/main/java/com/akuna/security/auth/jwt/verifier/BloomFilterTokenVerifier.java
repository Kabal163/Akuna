package com.akuna.security.auth.jwt.verifier;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 8, 2018
 */

import org.springframework.stereotype.Component;

//todo custom implementation
@Component
public class BloomFilterTokenVerifier implements TokenVerifier
{
    @Override
    public boolean verify(String jti) {
        return true;
    }
}
