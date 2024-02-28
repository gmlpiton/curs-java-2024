package org.gmlpiton.week5.objectcontainers.domain.persons;

import org.gmlpiton.week5.objectcontainers.domain.persons.Person;

public class Student extends Person {
    private String college;
    final private String type = "Student";

    @Override
    public String getType() {
        return type;
    }

    public Student(String name, String cnp, int age) {
        super(name, cnp, age);
    }

    public Student(String name, String cnp, int age, String college) {
        this(name, cnp, age);
        this.college = college;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return  super.toString() + "  Student{" +
                "college='" + college + '\'' +
                ", type='" + type + '\'' +
                '}' ;
    }
}
