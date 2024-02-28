package org.gmlpiton.week5.objectcontainers.domain.hobbies;

public class Country {
    private String country;

    public Country(String country) {
        this.country = country;
        this.continent = "Europe";
    }

    public Country(String country, String continent) {
        this.country = country;
        this.continent = continent;
    }


    private String continent;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country='" + country + '\'' +
                ", continent='" + continent + '\'' +
                '}';
    }
}
