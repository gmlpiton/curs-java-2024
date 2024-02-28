package org.gmlpiton.week4.phoneappli;

import org.gmlpiton.week4.phoneappli.Contact.Contact;
import org.gmlpiton.week4.phoneappli.Phone.Apple.AppleIPhone11;
import org.gmlpiton.week4.phoneappli.Phone.Apple.AppleIPhone15;
import org.gmlpiton.week4.phoneappli.Phone.Phone;
import org.gmlpiton.week4.phoneappli.Phone.Samsung.SamsungGalaxy22;
import org.gmlpiton.week4.phoneappli.Phone.Samsung.SamsungGalaxy6;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.print("Hello and welcome to phone application!\n");

        Contact testContact = new Contact("0770", "TT", "AV");
        System.out.println(testContact);


        Phone myPhone1S = new SamsungGalaxy6();
        Phone myPhone2S = new SamsungGalaxy22();
        Phone myPhone1I = new AppleIPhone11();
        Phone myPhone2I = new AppleIPhone15();
        System.out.println(myPhone1S);
        System.out.println(myPhone2S);
        System.out.println(myPhone1I);
        System.out.println(myPhone2I);

        Phone phone = new SamsungGalaxy6();

        phone.addContact("1", "0770777888", "John", "Smith");
        phone.addContact("2", "0774222333", "Adam", "Grant");

        final Contact c1 = phone.getFirstContact();
        final Contact c2 = phone.getLastContact();
        System.out.println(c2);

        phone.sendMessage(c1.getPhoneNumber(), "This is 1st message for c1");
        System.out.println(phone);
        phone.sendMessage(c1.getPhoneNumber(), "This is the 2nd message for c1");
        System.out.println(phone);


        phone.getFirstMessage("0770777888");
        phone.getSecondMessage("0770777888");

        phone.call("0774222333");
        System.out.println(phone);

        System.out.println();
        phone.viewHistory();

        System.out.println("This is just a final message");


    }
}