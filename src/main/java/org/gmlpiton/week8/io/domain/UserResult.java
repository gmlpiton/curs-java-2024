package org.gmlpiton.week8.io;

import org.gmlpiton.week8.io.places.Place;
import org.gmlpiton.week8.io.utils.PatternChecks;

import java.util.Locale;

public class UserResult {

    private final static int ADDED_DELAY_PER_MISS = 10;

    private String athleteNumber;
    private String athleteName;
    private String country;
    private String time;
    private String firstShooting;
    private String secondShooting;
    private String thirdShooting;

    private int calculatedTimeInSeconds;

    private Place place ;

    public UserResult(String athleteNumber, String user, String country, String time, String firstShooting, String secondShooting, String thirdShooting) {
        this.athleteNumber = athleteNumber;
        this.athleteName = user;
        this.country = country;
        this.time = time;
        this.firstShooting = firstShooting;
        this.secondShooting = secondShooting;
        this.thirdShooting = thirdShooting;
        calculateTimeInSeconds();
    }

    private void calculateTimeInSeconds () {
        calculatedTimeInSeconds = 0;
        int timeMins = Integer.parseInt(time.split(":")[0]);
        int timeSecs = Integer.parseInt(time.split(":")[1]);
        int timeMinsSecs = timeMins * 60 + timeSecs;
        int noDelays = PatternChecks.checkCounts(firstShooting.toLowerCase(Locale.ROOT),"o");
        noDelays += PatternChecks.checkCounts(secondShooting.toLowerCase(Locale.ROOT),"o");
        noDelays += PatternChecks.checkCounts(thirdShooting.toLowerCase(Locale.ROOT),"o");
        timeMinsSecs += ADDED_DELAY_PER_MISS *noDelays;
        calculatedTimeInSeconds = timeMinsSecs;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getCalculatedTime() {
        return calculatedTimeInSeconds;
    }

    public void setCalculatedTime(int calculatedTime) {
        this.calculatedTimeInSeconds = calculatedTime;
    }



    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFirstShooting() {
        return firstShooting;
    }

    public void setFirstShooting(String firstShooting) {
        this.firstShooting = firstShooting;
    }

    public String getSecondShooting() {
        return secondShooting;
    }

    public void setSecondShooting(String secondShooting) {
        this.secondShooting = secondShooting;
    }

    public String getThirdShooting() {
        return thirdShooting;
    }

    public void setThirdShooting(String thirdShooting) {
        this.thirdShooting = thirdShooting;
    }

    @Override
    public String toString() {
        if (place != null){
        return "UserResult{" +
                "athleteNumber='" + athleteNumber + '\'' +
                ", athleteName='" + athleteName + '\'' +
                ", country='" + country + '\'' +
                ", place=" + place + '\'' +
                ", time='" + time + '\'' +
                ", firstShooting='" + firstShooting + '\'' +
                ", secondShooting='" + secondShooting + '\'' +
                ", thirdShooting='" + thirdShooting + '\'' +
                ", calculatedTimeInSeconds=" + calculatedTimeInSeconds +
                '}';}

        return "UserResult{" +
                "athleteNumber='" + athleteNumber + '\'' +
                ", athleteName='" + athleteName + '\'' +
                ", country='" + country + '\'' +
                ", time='" + time + '\'' +
                ", firstShooting='" + firstShooting + '\'' +
                ", secondShooting='" + secondShooting + '\'' +
                ", thirdShooting='" + thirdShooting + '\'' +
                ", calculatedTimeInSeconds=" + calculatedTimeInSeconds +
                '}';
    }
}
