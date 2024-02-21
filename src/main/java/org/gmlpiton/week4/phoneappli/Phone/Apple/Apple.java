package org.gmlpiton.week4.phoneappli.Phone.Apple;

import org.gmlpiton.week4.phoneappli.Phone.Phone;

public class Apple extends Phone {

    protected final String brand = "Apple";

    public String getBrand() {
        return brand;
    }

    public Apple() {
        this.batteryLife = 150;
        this.color = "MetalBlack";
        this.iIMEI = "387788191234582";
        this.material = "Gold";
    }

    public Apple(final String iIMEI) {
        this.batteryLife = 150;
        this.color = "MetalBlack";
        this.iIMEI = iIMEI;
        this.material = "Gold";

    }


    @Override
    public String toString() {
        return "Apple{" +
                "brand='" + brand + '\'' +
                '}';
    }
}

