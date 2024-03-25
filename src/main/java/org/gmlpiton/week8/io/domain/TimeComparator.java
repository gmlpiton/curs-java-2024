package org.gmlpiton.week8.io.domain;

import java.util.Comparator;

public class TimeComparator implements Comparator<UserResult> {

    @Override
    public int compare(UserResult o1, UserResult o2) {
        return o1.getCalculatedTime() - o2.getCalculatedTime();

    }
}
