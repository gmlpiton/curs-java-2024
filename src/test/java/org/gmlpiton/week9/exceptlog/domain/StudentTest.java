package org.gmlpiton.week9.exceptlog.domain;

import org.gmlpiton.week9.exceptlog.exception.InvalidCNPFormatException;
import org.gmlpiton.week9.exceptlog.exception.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {
    @ParameterizedTest
    @CsvSource(value = {
            "John, Smith, 2004, 12, 31, M, 5200412312224",
            "Ada, Brown, 2003, 2, 11, F, 8200302112557"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void isStudentCreatingOK(String fn, String ln, int yy, int mm, int dd, String sex, String cnp) {

        Student s = new Student(fn, ln, yy, mm, dd, sex, cnp);

        assertEquals(s.getLastName(), ln);
        assertEquals(s.getFirstName(), fn);
        assertEquals(s.getCNP().toString(), cnp);
        assertEquals(s.getDateOfBirth().getDay(), dd);
        assertEquals(s.getDateOfBirth().getYear(), yy);
        assertEquals(s.getDateOfBirth().getMonth(), mm);

    }


    @Test
    void ageTestingGreater() {

        Exception exception = assertThrows(ValidationException.class, () ->
                new Student("Iain", "Idol", 3028, 1, 11, "f", "7200302112557"));
        assertEquals("Year 3028 is not valid", exception.getMessage()); //put 3028 to avoid fail any time soon
    }

    @Test
    void ageTestingSmaller() {

        Exception exception = assertThrows(ValidationException.class, () ->
                new Student("Iain", "Idol", 1899, 1, 11, "f", "7200302112557"));
        assertEquals("Year 1899 is not valid", exception.getMessage());
    }


    @Test
    void CnpTesting() {

        Exception exception = assertThrows(InvalidCNPFormatException.class, () ->
                new Student("Iain", "Idol", 2001, 1, 11, "f", "720030211"));
        assertEquals("CNP is not valid", exception.getMessage());
    }
    @Test
    void genderNOKTestSuccess() {

        Exception exception = assertThrows(ValidationException.class, () ->
                new Student("Iain", "Idol", 2002, 1, 11, "x", "7200302112557"));
        assertEquals("Gender is not valid", exception.getMessage());
    }

    @Test
    void lastNameNullTestSuccess() {

        Exception exception = assertThrows(ValidationException.class, () ->
                new Student("Iain", "", 2002, 1, 11, "x", "7200302112557"));
        assertEquals("Last name is empty", exception.getMessage());
    }

    @Test
    void firstNameNullTestSuccess() {

        Exception exception = assertThrows(ValidationException.class, () ->
                new Student("", "Idol", 2002, 1, 11, "x", "7200302112557"));
        assertEquals("First name is empty", exception.getMessage());
    }

}



