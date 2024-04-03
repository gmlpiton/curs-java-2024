package org.gmlpiton.week9.exceptlog.exception;

public class InvalidCNPFormatException extends CNPException {

    public InvalidCNPFormatException() {
        super("CNP is not valid");
    }
}