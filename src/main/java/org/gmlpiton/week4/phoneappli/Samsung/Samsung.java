package org.gmlpiton.week4.phoneappli.Samsung;

import org.gmlpiton.week4.phoneappli.Phone;

public abstract class Samsung extends Phone {
    protected final String brand = "Samsung";

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Samsung{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
