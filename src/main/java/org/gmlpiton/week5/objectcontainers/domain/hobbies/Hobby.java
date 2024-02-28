package org.gmlpiton.week5.objectcontainers.domain.hobbies;

import org.gmlpiton.week5.objectcontainers.domain.hobbies.Address;

import java.util.List;

public class Hobby {
    private String hobbyName;
    private int frequency;
    private List<Address> addressList;

    public Hobby(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobbyName='" + hobbyName + '\'' +
                ", frequency=" + frequency +
                ", addressList=" + addressList +
                '}';
    }
}
