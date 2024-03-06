package org.gmlpiton.week6.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionResultTest {
    @Test
    public void testAdd(){
        System.out.println("Just test Junit is working");
        int result = 2 + 2;
        assertEquals(4, result);
    }

    @ParameterizedTest
    @CsvSource(value= {
            "100, mm" ,
            "30, cm",
            "99, dm",
            "997, m",
            "2300, km"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void isSettingValUmReflectedInAttrib (int val, String um)
    {
        final ExpressionResult er = new ExpressionResult(val, um);
        assertEquals(val, er.getValue());
        assertEquals(um, er.getUm());
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void testMethod(int argument) {
        final ExpressionResult er = new ExpressionResult(argument, "m");
        assertEquals(argument, er.getValue());
        assertNotEquals (argument, er.getValue()-1);
    }


}