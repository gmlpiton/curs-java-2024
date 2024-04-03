package org.gmlpiton.week9.exceptlog.domain;

import org.gmlpiton.week8.io.domain.Place;

import java.util.Locale;
import java.util.Objects;

public enum Gender {
    M("Male", "M"),
    F("Female", "F"),
    NA("NA", "NA");

    final String genderName;
    final String genderShortName;

    Gender(final String genderName, final String genderShortName) {
        this.genderName = genderName;
        this.genderShortName = genderShortName;
    }

    public String getGenderName() {
        return genderName;
    }

    public String getGenderShortName() {
        return genderShortName;
    }

    public static String whatIsValid() {
        StringBuilder validInput = new StringBuilder();
        for (Gender gender : Gender.values()) {
            validInput.append(gender.getGenderShortName()).append("/");
        }
        return validInput.toString().toUpperCase(Locale.ROOT).substring(0, validInput.toString().length() - 1 );

    }

    public static Gender getForValue(String ggender){
        for (Gender gender: Gender.values()){
            if(Objects.equals(gender.getGenderShortName(), ggender.toUpperCase())){
                return gender;
            }
        }
        return null;
    }


}
