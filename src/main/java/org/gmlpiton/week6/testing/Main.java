package org.gmlpiton.week6.testing;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        System.out.println("Starting testing appli");

        String input = "10 cM +1m- 70 dm + 1Km";

        Calculator c = new Calculator(input);
        System.out.println(c);

        //List<String> groups = c.extractGroups(c.getGivenExpression().toLowerCase(), pattern);
        System.out.println(c.isExpressionValid());

        System.out.println(c.calculateResult()) ;
        System.out.println(Calculator.UNITS_SCALES);



    }
}
