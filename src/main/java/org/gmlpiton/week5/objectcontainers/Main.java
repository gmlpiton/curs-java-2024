package org.gmlpiton.week5.objectcontainers;

import org.gmlpiton.week5.objectcontainers.domain.Address;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting object containers appli");

        Address myAddress = new Address();
        System.out.println(myAddress);

        Address myAddress1 = new Address("Florilor", 1, "700400");
        myAddress1.setOtherAddressData("Bl. M2 et. 1 ap. 7");
        System.out.println(myAddress1);
    }
}
