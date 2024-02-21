package org.gmlpiton.week4.phoneappli;

import org.gmlpiton.week4.phoneappli.Apple.AppleIPhone15;
import org.gmlpiton.week4.phoneappli.Samsung.SamsungGalaxy6;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome to phone application!\n");

        Contact testContact = new Contact( "0770", "TT", "AV");
        System.out.println(testContact);

        Phone myPhone1 = new SamsungGalaxy6() ;
        Phone myPhone2 = new AppleIPhone15();


    }
}