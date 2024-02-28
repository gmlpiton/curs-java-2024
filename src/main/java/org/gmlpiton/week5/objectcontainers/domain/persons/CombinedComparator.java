package org.gmlpiton.week5.objectcontainers.domain.persons;

import java.util.Comparator;

public class CombinedComparator implements Comparator<Person> {
    private final AgeComparator ageComparator = new AgeComparator();
    private final NameComparator nameComparator = new NameComparator();

    @Override
    public int compare(Person p1, Person p2) {
        // First compare by age
        int ageComparison = ageComparator.compare(p1, p2);
        if (ageComparison != 0) {
            return ageComparison;
        }

        // If ages are equal, compare by name
        return nameComparator.compare(p1, p2);
    }
}