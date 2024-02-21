package org.gmlpiton.week4.phoneappli.Phone;

import org.gmlpiton.week4.phoneappli.Contact.Contact;
import org.gmlpiton.week4.phoneappli.Contact.Message;
import org.gmlpiton.week4.phoneappli.Utils;


public abstract class Phone {
    protected int batteryLife;
    protected String color;
    protected String material;
    protected String iIMEI;
    protected Contact contact1;
    protected Contact contact2;
    protected Message con1Mess1;
    protected Message con1Mess2;
    protected Message con2Mess1;
    protected Message con2Mess2;

    protected String history = "";

    public void addContact(String id, String phoneNumber, String firstName, String lastName) {
        if (id.equals("1")) {
            this.contact1 = new Contact(phoneNumber, firstName, lastName);
        } else if (id.equals("2")) {
            this.contact2 = new Contact(phoneNumber, firstName, lastName);
        }
    }

    public Contact getFirstContact() {
        System.out.println(contact1);
        return contact1;
    }

    public Contact getLastContact() {
        System.out.println(contact2);
        return contact2;
    }

    public void sendMessage(String phoneNumber, String messageContent) {
        this.batteryLife -= 1;
        this.history += Utils.printToMyLog("Sent message to " + phoneNumber );

        if (contact1.getPhoneNumber().equals(phoneNumber)) {
            if (con1Mess1 == null) {
                con1Mess1 = new Message(phoneNumber, messageContent);
            } else {
                con1Mess2 = new Message(phoneNumber, messageContent);
            }
        } else if (contact2.getPhoneNumber().equals(phoneNumber)) {
            if (con2Mess1 == null) {
                con2Mess1 = new Message(phoneNumber, messageContent);
            } else {
                con2Mess2 = new Message(phoneNumber, messageContent);
            }
        }

    }


    public void getFirstMessage(String phoneNumber) {
        if (contact1.getPhoneNumber().equals(phoneNumber)) {
            System.out.println(con1Mess1.getMessageValue());
        } else if (contact2.getPhoneNumber().equals(phoneNumber)) {
            System.out.println(con2Mess1.getMessageValue());
        }
    }

    public void getSecondMessage(String phoneNumber) {
        if (contact1.getPhoneNumber().equals(phoneNumber)) {
            System.out.println(con1Mess2.getMessageValue());
        } else if (contact2.getPhoneNumber().equals(phoneNumber)) {
            System.out.println(con2Mess2.getMessageValue());
        }
    }

    public void call(String phoneNumber) {
        this.batteryLife -= 2;
        this.history += Utils.printToMyLog("Called " + phoneNumber );
    }


    public void viewHistory() {
        System.out.println("History is:");
        System.out.println(this.history);
    }
}

