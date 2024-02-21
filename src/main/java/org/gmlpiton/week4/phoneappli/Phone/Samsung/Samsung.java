package org.gmlpiton.week4.phoneappli.Phone.Samsung;

import org.gmlpiton.week4.phoneappli.Phone.Phone;

public abstract class Samsung extends Phone {
    protected final String brand = "Samsung";

    public String getBrand() {
        return brand;
    }

    public Samsung() {
        this.batteryLife = 100;
        this.color = "Black";
        this.iIMEI = "357788191234560";
        this.material = "Carbon";
    }

    public Samsung(final String iIMEI) {
        this.batteryLife = 150;
        this.color = "Black";
        this.iIMEI = iIMEI;
        this.material = "Carbon";
    }

    @Override
    public String toString() {
        return "Samsung{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
