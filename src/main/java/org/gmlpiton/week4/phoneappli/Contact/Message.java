package org.gmlpiton.week4.phoneappli.Contact;

public class Message {
    private String phoneNumber;
    private String messageValue;

    public Message(String phoneNumber, String messageContent) {
        this.phoneNumber = phoneNumber;
        this.messageValue = messageContent;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessageValue() {
        return messageValue;
    }

    public void setMessageValue(String messageValue) {
        this.messageValue = messageValue;
    }

    @Override
    public String toString() {
        return "Message{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", messageValue='" + messageValue + '\'' +
                '}';
    }
}
