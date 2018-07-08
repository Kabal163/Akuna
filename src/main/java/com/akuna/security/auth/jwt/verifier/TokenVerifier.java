package com.akuna.security.auth.jwt.verifier;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 8, 2018
 */

public interface TokenVerifier
{
    public boolean verify(String jti);
}
