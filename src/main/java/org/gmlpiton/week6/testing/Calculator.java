package org.gmlpiton.week6.testing;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static final String pattern = "(\\+?\\-?\\s?\\d+\\s?(?:cm|mm|m|km|dm))";
    public static final Map<String, Integer> UNITS_SCALES;

    static {
        LinkedHashMap<String, Integer> tmp = new LinkedHashMap<>();  //use LinkedHashMap to preserve insert order
        tmp.put("mm", 1);
        tmp.put("cm", 10);
        tmp.put("dm", 100);
        tmp.put("km", 1000000);
        tmp.put("m", 1000);
        UNITS_SCALES = Collections.unmodifiableMap(tmp);
    }

    final private String givenExpression;
    final private String lowerExpression;
    private ExpressionResult result;


    public Calculator(String expression) {
        givenExpression = expression;
        lowerExpression = givenExpression.toLowerCase();
    }

    public List<String> extractGroups(String input, String pattern) {

        return getStrings(input, pattern);
    }

    private static List<String> getStrings(String input, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        List<String> groups = new ArrayList<>();

        while (m.find()) {
            String g = m.group();
            //System.out.println(g); // Print the entire matched group
            groups.add(g);
        }
        return groups;
    }

    public boolean isExpressionValid()
    {  List<String> groups = extractGroups(this.lowerExpression, pattern);
        StringBuilder reconstrLowerExpression = new StringBuilder();
        for (String g : groups)
        {
            reconstrLowerExpression.append(g.replaceAll("\\s", ""));

        }

        //System.out.println("reconstrLowerExpression="+ reconstrLowerExpression.toString());

        return 0==reconstrLowerExpression.compareTo(new StringBuilder(lowerExpression.replaceAll("\\s", "")));

    }


    public String getGivenExpression() {
        return givenExpression;
    }

    public ExpressionResult getResult() {
        return result;
    }

    public void setResult(ExpressionResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Calculator{" + "givenExpression='" + givenExpression + '\'' + ", lowerExpression='" + lowerExpression + '\'' + ", result='" + result + '\'' + '}';
    }

    public ExpressionResult calculateResult() {
        int valueCalc = 0;
        int scaleMin = Integer.MAX_VALUE;
        String unitMin = "";
        List<String> groups = this.extractGroups(lowerExpression, pattern);
        ExpressionResult res = new ExpressionResult();
        for (String g : groups) {
            int gScale = 1;
            for (String key : UNITS_SCALES.keySet()) {
                //System.out.println(key);
                if (g.contains(key)) // found unit
                {
                    //System.out.println("Found " + key + " in " + g);
                    int lScaleMin = UNITS_SCALES.get(key);

                    if (lScaleMin < scaleMin) {
                        scaleMin = lScaleMin;
                        unitMin = key;
                    }
                    //System.out.println("lValMin=" + lScaleMin + " unitMin=" + unitMin);
                    gScale = lScaleMin;

                    break;
                }


            }
            //get value in group
            String gValue = getStrings(g, "\\d+").get(0);
            //System.out.println("Group Value = " + gValue + "group scale = "+ gScale);

            boolean shouldIncrement;
            shouldIncrement = !g.contains("-");
            if (shouldIncrement) {
                valueCalc += Integer.parseInt(gValue) * gScale;
            } else {
                valueCalc -= Integer.parseInt(gValue) * gScale;
            }

            //System.out.println("-----------------");




        }

        //System.out.println("Value = "+valueCalc +" mm" + " unitMin = " +unitMin);
        int valueCalcUserUnit = valueCalc/UNITS_SCALES.get(unitMin);

        //System.out.println("Value to show= "+ valueCalcUserUnit +" " +unitMin);

        res.setValue(valueCalcUserUnit);
        res.setUm(unitMin);

        this.setResult(res);

        return res;


    }
}
