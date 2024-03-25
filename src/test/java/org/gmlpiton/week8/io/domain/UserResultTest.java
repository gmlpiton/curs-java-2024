package org.gmlpiton.week8.io.domain;

import org.gmlpiton.week8.io.utils.Utils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UserResultTest {

    @ParameterizedTest
    @CsvSource(value = {
            "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo,30:57,30",
            "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo, 30:15,60",
            "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx,30:10,0"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void isCSVParsingOK(String an, String name, String country, String time,
                               String s1, String s2, String s3, String ct, String cd) {

        UserResult ur = new UserResult(an, name, country, time, s1, s2, s3);

        assertEquals(cd, String.valueOf(ur.getDelayInSeconds()));
        assertEquals(ct, Utils.getMMSSFromSeconds(ur.getCalculatedTime()));



    }




}