package org.gmlpiton.week9.exceptlog.domain;

public class BirthDay {
    private int year;
    private int month;
    private int day;

    private int hour;
    private int minute;

    public BirthDay() {
    }

    public BirthDay(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "BirthDay{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
