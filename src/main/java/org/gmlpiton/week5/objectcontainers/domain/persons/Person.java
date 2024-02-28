package org.gmlpiton.week5.objectcontainers.domain.persons;


import org.gmlpiton.week5.objectcontainers.domain.hobbies.Hobby;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private String name;
    protected String type;
    private final String cnp;
    private int age;
    private List<Hobby> hobbies = new ArrayList<Hobby>();

    public Person(final String name, final String cnp, final int age) {
        this.name = name;
        this.cnp = cnp;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCnp() {
        return cnp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public void addHobby(Hobby hobby) {
        this.hobbies.add(hobby);
    }

    public void removeHobby(Hobby hobby) {
        this.hobbies.remove(hobby);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", cnp='" + cnp + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }
}
