package org.gmlpiton.week5.objectcontainers.domain.persons;

import org.gmlpiton.week5.objectcontainers.domain.persons.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
