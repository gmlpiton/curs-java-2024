package org.gmlpiton.week9.exceptlog.domain;

import org.gmlpiton.week8.io.domain.TimeComparator;
import org.gmlpiton.week9.exceptlog.exception.ValidationException;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private List<Student> sr = new ArrayList<>();

    public void addStudent(Student student) {
        sr.add(student);
    }

    public void deleteStudentByPos(int pos) {
        sr.remove(pos);
    }

    public void deleteStudentByStudent(Student s) {
        sr.remove(s);
    }

    public int calculateAge(Student s) {

        LocalDate bd = LocalDate.of(s.getDataOfBirth().getYear(), s.getDataOfBirth().getMonth(), s.getDataOfBirth().getDay());
        LocalDate now = LocalDate.now();
        Period period = Period.between(bd, LocalDate.now());
        int age = period.getYears();
        if (age < 18) {
            throw new ValidationException("Age is too little: " + age, 1);
        }


        //System.out.println(period.getYears());
        return age;

    }

    public List<Student> getAllStudentsAgeX(int age) {
        List<Student> l = new ArrayList<>();
        for (Student s : sr) {
            if (calculateAge(s) == age) {
                l.add(s);
            }
        }
        return l;
    }

    public void listStudents()
    {
        sr.sort(new LastNameComparator());
        for (Student s: sr)
        {
            System.out.println(s);
        }
    }

    public StudentRepository() {
    }

    public StudentRepository(List<Student> sr) {
        this.sr = sr;
    }

    public List<Student> getSr() {
        return sr;
    }

    public void setSr(List<Student> sr) {
        this.sr = sr;
    }
}
