package org.gmlpiton.week8.io.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternChecks {
    public static int checkCounts( String str, String pat ) {
        Pattern p = Pattern.compile(pat);
        Matcher m = p.matcher(str);
        int count = 0;
        while (m.find()) {
            count += 1;
        }
        return count;
    }

}
