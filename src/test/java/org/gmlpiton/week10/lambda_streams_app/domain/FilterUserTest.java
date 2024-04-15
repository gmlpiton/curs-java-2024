package org.gmlpiton.week10.lambda_streams_app.domain;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) //used so that my List is not destroyed between

class FilterUserTest {
    List<User> users = new ArrayList<>();

    @ParameterizedTest
    @CsvSource(value = {
            "George,Ionescu,24/02/1985",
            "Virgil ,Popescu,23/12/1990",
            "Greta,Vasilescu,21/11/1994",
            "George,Vasilescu,21/11/1995",
            "Aldous,Vasilescu,23/11/1996",
            "Joan,Anderson,17/11/1982",
            "Eleanor,Endeavor,12/11/1989",
            "Ithsihuro,Matshusita,07/11/1991",
            "Fran�ois,Timoth�,01/11/1990",
            "Ida,Bergsson,01/02/1988",
            "Camille ,Delafleur,07/02/1987",
            "Ho,Fengshui,23/07/1981",
            "Miguel,Delgado,11/07/1985",
            "Joao,Pinto,23/07/1984"
    })
    public void isMyFilteringOK(String fn, String ln, String bd) {
        LocalDate ld = LocalDate.of(Integer.parseInt(bd.split("/")[2]),
                Integer.parseInt(bd.split("/")[1]),
                Integer.parseInt(bd.split("/")[0])
        );
        User u = new User(fn, ln, ld);

        users.add(u);

        if (users.size() == 14) {
            System.out.println("All users read");

            assertEquals(FilterUser.getUsers(users, 11).size(), 7);

            assertEquals((FilterUser.getUsers(users, 8).size()), 0);
        }


    }

    @ParameterizedTest
    @CsvSource(value = {
            "George,Ionescu,24/02/1985",
            "Virgil ,Popescu,23/12/1990",
            "Greta,Vasilescu,21/11/1994",
            "George,Vasilescu,21/11/1995",
            "Aldous,Vasilescu,23/11/1996",
            "Joan,Anderson,17/11/1982",
            "Eleanor,Endeavor,12/11/1989",
            "Ithsihuro,Matshusita,07/11/1991",
            "Fran�ois,Timoth�,01/11/1990",
            "Ida,Bergsson,01/02/1988",
            "Camille ,Delafleur,07/02/1987",
            "Ho,Fengshui,23/07/1981",
            "Miguel,Delgado,11/07/1985",
            "Joao,Pinto,23/07/1984"
    })
    public void isMyOrderOk(String fn, String ln, String bd) {
        LocalDate ld = LocalDate.of(Integer.parseInt(bd.split("/")[2]),
                Integer.parseInt(bd.split("/")[1]),
                Integer.parseInt(bd.split("/")[0])
        );
        User u = new User(fn, ln, ld);

        users.add(u);

        if (users.size() == 14) {
            System.out.println("All users read again");

            List<User> fl = FilterUser.getUsers(users, 11);

            String res = fl.stream()
                    .filter(s-> Objects.equals(s.getLastName(), "Vasilescu"))
                    .map(User::getFirstName)
                    .collect(Collectors.joining("_"));

            assertEquals(res, "Aldous_George_Greta");

        }

    }

}