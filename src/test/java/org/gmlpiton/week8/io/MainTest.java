package org.gmlpiton.week8.io;

import org.gmlpiton.week8.io.domain.Place;
import org.gmlpiton.week8.io.domain.UserResult;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.gmlpiton.week8.io.Main.calculateRanks;
import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS) //used so that my List is not destroyed between
// parameterized runs
class MainTest {

    List<UserResult> urs = new ArrayList<>();

    @ParameterizedTest
    @CsvSource(value = {
            "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo,30:57,30",
            "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo, 30:15,60",
            "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx,30:10,0"
    })
    public void isMyRankingOK(String an, String name, String country, String time,
                              String s1, String s2, String s3) {

        UserResult ur = new UserResult(an, name, country, time, s1, s2, s3);

        urs.add(ur);

        System.out.println(urs.size());

        calculateRanks(urs);
        if (urs.size() == 3) //list is complete
        {assertEquals(urs.get(0).getPlace(), Place.P1);
            assertEquals(urs.get(1).getPlace(), Place.P2);
            assertEquals(urs.get(2).getPlace(), Place.P3);}


    }
}