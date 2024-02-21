package org.gmlpiton.week4.phoneappli;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String getDateNow() {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    public static String printToMyLog(String text) {
        return getDateNow() + ": " + text + "\n";
    }
}
