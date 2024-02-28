package org.gmlpiton.week5.objectcontainers.domain;


public class Address {
    final private static String CITY = "Iasi";
    final private static String COUNTRY = "Romania";
    private String country;
    private String city;
    private String zipCode;
    private String streetName;
    private int streetNumber;
    private String otherAddressData;

    public Address() {
        country = COUNTRY;
        city = CITY;
    }

    public Address(String streetName, int streetNumber) {
        this();
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    public Address(String streetName, int streetNumber, String zipCode) {
        this(streetName, streetNumber);
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getOtherAddressData() {
        return otherAddressData;
    }

    public void setOtherAddressData(String otherAddressData) {
        this.otherAddressData = otherAddressData;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", otherAddressData='" + otherAddressData + '\'' +
                '}';
    }
}
