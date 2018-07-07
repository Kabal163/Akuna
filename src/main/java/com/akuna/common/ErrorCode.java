package com.akuna.common;

import org.codehaus.jackson.annotate.JsonValue;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 7, 2018
 */

public enum ErrorCode
{
    GLOBAL(2),
    AUTHENTICATION(10),
    JWT_TOKEN_EXPIRED(11);

    private int errorCode;

    ErrorCode(int errorCode)
    {
        this.errorCode = errorCode;
    }

    @JsonValue
    public int getErrorCode()
    {
        return this.errorCode;
    }
}
