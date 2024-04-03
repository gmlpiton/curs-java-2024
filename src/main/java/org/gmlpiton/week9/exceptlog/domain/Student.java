package org.gmlpiton.week9.exceptlog.domain;

import org.gmlpiton.week9.exceptlog.domain.cnp.Cnp;
import org.gmlpiton.week9.exceptlog.exception.ValidationException;

import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private BirthDay dateOfBirth;
    private Gender gender;
    private Cnp CNP;

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, int yearBirth, int monthBirth, int dayBirth, String gender, String CNP) {
        if (isStringEmpty(firstName)) {
            //System.out.println(cnp.length());
            throw new ValidationException("First name is empty", 2);
        }
        if (isStringEmpty(lastName)) {
            //System.out.println(cnp.length());
            throw new ValidationException("Last name is empty", 3);
        }
        this.firstName = firstName;
        this.lastName = lastName;
        if (!isYearValid(yearBirth)) {
            throw new ValidationException("Year " + yearBirth + " is not valid", 4);
        }

        this.dateOfBirth = new BirthDay(yearBirth, monthBirth, dayBirth);

        Gender lgender = Gender.getForValue(gender);
        if (lgender == null) {
            throw new ValidationException("Gender is not valid", 5);
        }
        this.gender = lgender;
        this.CNP = new Cnp(CNP);
    }

    private boolean isStringEmpty(String str) {
        return !(str != null && !str.trim().isEmpty());
    }

    private boolean isYearValid(int year) {
        return 1900 < year && year < LocalDate.now().getYear() - 18;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (isStringEmpty(firstName)) {
            //System.out.println(cnp.length());
            throw new ValidationException("First name is empty", 2);
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (isStringEmpty(lastName)) {
            //System.out.println(cnp.length());
            throw new ValidationException("Last name is empty", 2);
        }
        this.lastName = lastName;
    }

    public BirthDay getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(BirthDay dateOfBirth) {
        if (!isYearValid(dateOfBirth.getYear())) {
            throw new ValidationException("Year" + dateOfBirth.getYear() + " is not valid", 4);
        }
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Cnp getCNP() {
        return CNP;
    }

    public void setCNP(Cnp CNP) {
        this.CNP = CNP;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dataOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", CNP='" + CNP + '\'' +
                '}';
    }
}
