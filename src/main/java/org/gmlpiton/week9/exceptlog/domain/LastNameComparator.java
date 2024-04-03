package org.gmlpiton.week9.exceptlog.domain;

public class LastNameComparator implements java.util.Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
    }
}
