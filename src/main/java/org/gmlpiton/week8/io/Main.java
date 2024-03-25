package org.gmlpiton.week8.io;

import org.gmlpiton.week8.io.domain.FileResult;
import org.gmlpiton.week8.io.domain.Place;
import org.gmlpiton.week8.io.domain.TimeComparator;
import org.gmlpiton.week8.io.domain.UserResult;
import org.gmlpiton.week8.io.utils.Utils;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is Ski Biathlon Standings app");

        final Place p2 = Place.P2;


        System.out.println("place name= " + p2.getPlace());


        List<UserResult> results = null;
        try {
            results = FileResult.readFromFileBufferedTryWithResources("results.csv");
            //System.out.println(results);

        } catch (IOException e) {
            System.out.println("Cannot open results file " + e);
        }
        if (results != null) {
            printUserResults(results);

            calculateRanks(results);

            //printUserResults(results);

            printFinalResults(results);

        }
    }

    private static void printUserResults(List<UserResult> results) {
        for (UserResult ur : results) {
            System.out.println("Show user: " + ur.getAthleteName() + " from " + ur.getCountry());
            System.out.println(ur);
        }
    }

    private static void printFinalResults(List<UserResult> results) {
        int i = 1;
        for (UserResult ur : results) {
            System.out.println(ur.getPlace().getPlaceName() + " - " + ur.getAthleteName() + " " +
                    Utils.getMMSSFromSeconds(ur.getCalculatedTime()) + " (" +
                    ur.getTime() + " + " +
                    //Utils.leftPad(String.valueOf(ur.getDelayInSeconds()),2,"0")
                    ur.getDelayInSeconds()
                    + ")" );
            if (i == 3) {
                break;
            }
            i += 1;
        }

    }

    public static void calculateRanks(List<UserResult> results) {
        results.sort(new TimeComparator());
        System.out.println("-------");

        int i = 1;
        for (UserResult ur : results) {
            if (i == 1) {
                ur.setPlace(Place.P1);
            } else if (i == 2) {
                ur.setPlace(Place.P2);
            } else if (i == 3) {
                ur.setPlace(Place.P3);
                break;
            }
            i += 1;

        }
    }

}
