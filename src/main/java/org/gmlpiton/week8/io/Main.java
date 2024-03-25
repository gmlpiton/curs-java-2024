package org.gmlpiton.week8.io;

import org.gmlpiton.week8.io.places.Place;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        System.out.println("This is Ski Biathlon Standings app");

        final Place p1  = Place.P1;
        final Place p2  = Place.P2;
        final Place p3  = Place.P3;


        System.out.println("place name= " + p2.getPlace());


        List<UserResult> results = null;
        try{
            results = FileResult.readFromFileBufferedTryWithResources("results.csv");
            //System.out.println(results);

        }
        catch (IOException e) {
            System.out.println("Cannot open results file "+ e);
        }
        if (results != null)
        {
            for(UserResult ur : results)
            {
                System.out.println("Calculate user time for user: "+ur.getAthleteName() + " from " + ur.getCountry());
                System.out.println(ur);
            }

        }

    }
}
