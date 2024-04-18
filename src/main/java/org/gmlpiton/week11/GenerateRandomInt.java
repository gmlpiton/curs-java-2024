package org.gmlpiton.week11;

import java.util.Random;

public class GenerateRandomInt {
    private static Random rand = new Random();

    private GenerateRandomInt() {
    }

    public static int get(int range) {
        return rand.nextInt(range);
    }

    public static TicketType getTT(int range)
    {
        return TicketType.getForValue(rand.nextInt(range)+1);
    }
}
