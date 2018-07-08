package com.akuna.security.auth.jwt.verifier;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 8, 2018
 */

//todo custom implementation
public class BloomFilterTokenVerifier implements TokenVerifier
{
    @Override
    public boolean verify(String jti) {
        return true;
    }
}
