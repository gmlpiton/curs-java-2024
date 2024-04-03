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
        assertEquals(s.getDataOfBirth().getDay(), dd);
        assertEquals(s.getDataOfBirth().getYear(), yy);
        assertEquals(s.getDataOfBirth().getMonth(), mm);

    }


    @Test
    void ageTesting() {

        Student student4 = new Student("Iain", "Idol", 2028, 1, 11, "f", "7200302112557");
        StudentRepository sr = new StudentRepository();
        sr.addStudent(student4);


        Exception exception = assertThrows(ValidationException.class, () ->
                sr.getAllStudentsAgeX(21));
        assertEquals("Age is too little: -3", exception.getMessage());
    }


    @Test
    void CnpTesting() {

        Exception exception = assertThrows(InvalidCNPFormatException.class, () ->
                new Student("Iain", "Idol", 2028, 1, 11, "f", "720030211"));
        assertEquals("CNP is not valid", exception.getMessage());
    }
}