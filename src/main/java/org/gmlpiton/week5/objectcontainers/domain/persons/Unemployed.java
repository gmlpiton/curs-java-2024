package org.gmlpiton.week5.objectcontainers.domain.persons;

public class Unemployed extends Person{
    private final String type = "onbenefits";
    public Unemployed(String name, String cnp, int age) {
        super(name, cnp, age);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + " Unemployed{" +
                "type='" + type + '\'' +
                '}';
    }
}
