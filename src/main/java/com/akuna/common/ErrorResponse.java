package com.akuna.common;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 7, 2018
 */

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorResponse
{
    private final HttpStatus status;

    private final String message;

    private final ErrorCode errorCode;

    private final Date timestamp;

    public ErrorResponse(final String message,
                         ErrorCode errorCode,
                         final HttpStatus status)
    {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.timestamp = new Date();
    }

    public static ErrorResponse of(final String message,
                                   ErrorCode errorCode,
                                   final HttpStatus status)
    {
        return new ErrorResponse(message, errorCode, status);
    }

    public HttpStatus getStatus()
    {
        return status;
    }

    public String getMessage()
    {
        return message;
    }

    public ErrorCode getErrorCode()
    {
        return errorCode;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }
}
