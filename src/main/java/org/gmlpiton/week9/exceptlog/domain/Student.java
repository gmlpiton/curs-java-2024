package org.gmlpiton.week9.exceptlog.domain;

import org.gmlpiton.week9.exceptlog.domain.BirthDay;
import org.gmlpiton.week9.exceptlog.domain.Gender;
import org.gmlpiton.week9.exceptlog.domain.cnp.Cnp;

public class Student {
    private String firstName;
    private String lastName;
    private BirthDay dateOfBirth;
    private Gender gender;
    private Cnp CNP ;

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, int yearBirth, int monthBirth, int dayBirth, String gender, String CNP) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = new BirthDay(yearBirth, monthBirth, dayBirth);
        this.gender =  Gender.NA;
        this.CNP = new Cnp(CNP);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BirthDay getDataOfBirth() {
        return dateOfBirth;
    }

    public void setDataOfBirth(BirthDay dataOfBirth) {
        this.dateOfBirth = dataOfBirth;
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
