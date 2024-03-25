package org.gmlpiton.week8.io.utils;



public class MyTime {

    public static String leftPad(String s, int len, String pad)
    {
        return String.format("%"+len+"s", s).replace(" ", pad);
    }

    public static String rightPad(String s, int len, String pad)
    {
        return String.format("%-"+len+"s", s).replace(" ", pad);
    }

    public static String getMMSSFromSeconds(int seconds)
    {
        int mi = seconds/60;
        int ss = seconds - mi*60;
        return leftPad(String.valueOf(mi), 2, "0")
                + ':' + leftPad(String.valueOf(ss), 2, "0") ;

        //String.format("%2s", String.valueOf(mi )).replace(' ', '0')
    }
}
