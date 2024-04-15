package org.gmlpiton.week10.lambda_streams_app.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//this is static class
public final class FilterUser {

    private FilterUser() {

    }

    public static List<User> getUsers(List<User> users, int month) {
        return users
                .stream()
                .filter(s -> s.getBirthDay().getMonth().getValue() == month)
                .sorted(Comparator.comparing(i2 -> (i2.getLastName() + "_" + i2.getFirstName())))
                .collect(Collectors.toList());
    }
}
