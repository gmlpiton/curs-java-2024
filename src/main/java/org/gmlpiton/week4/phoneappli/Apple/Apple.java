package org.gmlpiton.week4.phoneappli.Apple;

import org.gmlpiton.week4.phoneappli.Phone;

public class Apple extends Phone {

    protected final String brand = "Apple";

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "brand='" + brand + '\'' +
                '}';
    }
}

