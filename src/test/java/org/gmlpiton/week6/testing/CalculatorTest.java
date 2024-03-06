package org.gmlpiton.week6.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void is_calculateResult_OK() {
        String expression = "1 mm + 1 cm + 1dm + 1m + 1 km";
        Calculator c = new Calculator(expression);
        c.calculateResult();
        int exptectedResult = 1001111;
        String expectedUM = "mm";
        assertEquals(exptectedResult, c.getResult().getValue());
        assertEquals(expectedUM, c.getResult().getUm());

    }

    @Test
    void is_calculateResult_KO() {
        String expression = "1 mm + 1 cm + 1dm + 1m + 1 km";
        Calculator c = new Calculator(expression);
        c.calculateResult();
        int exptectedResult = 1001111;
        String expectedUM = "m";
        assertEquals(exptectedResult, c.getResult().getValue());
        assertNotEquals(expectedUM, c.getResult().getUm());

    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 mm + 1 cm + 1 dm + 1 m , 1111, mm",
            "1 mm + 1 cm , 11, mm",
            "1 cm + 1 dm, 11, cm ",
            "1 dm + 1 m, 11, dm ",
            "1 m + 1 m, 2, m ",
            "1 m + 1 km, 1001, m",
            "1 km + 1 km, 2, km",
            "1 km - 1 km, 0, km",
            "2mm -7 cm, -68, mm"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void isSettingValUmReflectedInAttrib(String expression, int valRes, String umRes) {
        Calculator c = new Calculator(expression);
        System.out.println(c.getGivenExpression());
        System.out.println(c.isExpressionValid());

        c.calculateResult();

        System.out.println(c.getResult());
        assertEquals(valRes, c.getResult().getValue());
        assertEquals(umRes, c.getResult().getUm());

    }

    @ParameterizedTest
    @ValueSource(strings = {"1mm + 1m + 2km",
            "1mm-1m+2km-10dm",
            "1 mm-2cm+6KM"})
    public void isValidExpression_True(String expression) {
        Calculator c = new Calculator(expression);
        assertTrue(c.isExpressionValid());

    }

    @ParameterizedTest
    @ValueSource(strings = {"1qm + 1m + 2km",
            "1mm-1mi+2km-10dm",
            "1 mm-2cm+6Kg"})
    public void isValidExpression_False(String expression) {
        Calculator c = new Calculator(expression);
        assertFalse(c.isExpressionValid());

    }

}