package org.gmlpiton.week4.phoneappli.Contact;

public class Contact {
    private String phoneNumber;
    private String firstName;
    private String lastName;

    public Contact() {
    }

    public Contact(String number, String firstName, String lastName) {

        this.phoneNumber = number;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
