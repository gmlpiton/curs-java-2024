package org.gmlpiton.week9.exceptlog.domain;

import java.util.Locale;

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


}
