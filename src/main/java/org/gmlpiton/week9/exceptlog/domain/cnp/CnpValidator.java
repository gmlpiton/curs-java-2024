package org.gmlpiton.week9.exceptlog.domain.cnp;

import org.gmlpiton.week9.exceptlog.exception.InvalidCNPFormatException;

import java.nio.charset.StandardCharsets;


public class CnpValidator {

    public static final int CNP_LENGTH = 13;

    public static void validate(final String cnp) {
        validateLength(cnp);
        /*
        validateFormat(cnp);
        validateCheckDigit(cnp);
        validateSexAndCentury(cnp);
        validateDateOfBirth(cnp);
        validateCounty(cnp);
        validateOrderNumber(cnp);
        */

    }

    private static void validateLength(final String cnp) {
        if (cnp.length() != CNP_LENGTH) {
            //System.out.println(cnp.length());
            throw new InvalidCNPFormatException();
        }
    }

    /*private static void validateFormat(final String cnp) {
        if (!isNumeric(cnp)) {
            throw new InvalidFormatException();
        }
    }

    private static void validateCheckDigit(final String cnp) {
        if (CHECK_DIGIT.from(cnp) != calculateCheckDigit(cnp)) {
            throw new InvalidCheckDigitException();
        }
    }

    private static void validateSexAndCentury(final String cnp) {
        int sexAndCentury = SEX_AND_CENTURY.from(cnp);
        Sex.getByCode(sexAndCentury);
        Century.getByCode(sexAndCentury);
    }

    private static void validateDateOfBirth(final String cnp) {
        Century century = Century.getByCode(SEX_AND_CENTURY.from(cnp));
        int year = century.getStartYear() + YEAR_OF_BIRTH.from(cnp);
        int month = MONTH_OF_BIRTH.from(cnp) - 1;
        int day = DAY_OF_BIRTH.from(cnp);
        buildDateOfBirth(year, month, day);
    }

    private static void validateCounty(final String cnp) {
        County.getByCode(COUNTY.from(cnp));
    }

    private static void validateOrderNumber(final String cnp) {
        if (ORDER_NUMBER.from(cnp) == 0) {
            throw new InvalidOrderNumberException();
        }
        */

    }

