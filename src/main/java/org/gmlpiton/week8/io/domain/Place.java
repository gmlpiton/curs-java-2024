package org.gmlpiton.week8.io.places;

public enum Place {
    P1("Winner", 1),
    P2("Runner-up", 2),
    P3("Third Place", 3);

    String placeName;
    int place;

    Place() {
    }

    Place(final String placeName, final int place)
        {
            this.placeName = placeName;
            this.place = place;
        }

    public String getPlaceName() {
        return placeName;
    }

    public int getPlace() {
        return place;
    }

    public static Place getForValue(int pplace){
        for (Place place: Place.values()){
            if(place.getPlace() == pplace){
                return place;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Places{" +
                "placeName='" + placeName + '\'' +
                ", place=" + place +
                '}';
    }
}


