package org.gmlpiton.week9.exceptlog.exception;

public class ValidationException extends RuntimeException
{
    private String reason;
    private int code;

    public ValidationException(String reason, int code)
    {
        super( reason);
        this.reason = reason;
        this.code = code;
    }

    public String getReason()
    {
        return reason;
    }

    public int getCode()
    {
        return code;
    }
}
