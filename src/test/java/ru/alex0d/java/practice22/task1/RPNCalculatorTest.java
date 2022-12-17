package ru.alex0d.java.practice22.task1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RPNCalculatorTest {

    @org.junit.jupiter.api.Test
    void calculate() {
        String expression = "2+3*2-1/2";
        Double result = RPNCalculator.calculate(expression);
        assertEquals(7.5, result);

        expression = "2+3*2-1/2+2*2";
        result = RPNCalculator.calculate(expression);
        assertEquals(11.5, result);

        expression = "2+3*2-1/2+2*2+2*2";
        result = RPNCalculator.calculate(expression);
        assertEquals(15.5, result);

        expression = "2+3*2-1/2+2*2+2-1.5-1";
        result = RPNCalculator.calculate(expression);
        assertEquals(11.0, result);

        expression = "2+3*2-1/2+2*2+2-1.5-1+2*0.4";
        result = RPNCalculator.calculate(expression);
        assertEquals(11.8, result);

        expression = "2+3*2-1//2";
        result = RPNCalculator.calculate(expression);
        assertNull(result);

        expression = "2+3*2-1/2+2*2+2-1.5-1+2*0.4+";
        result = RPNCalculator.calculate(expression);
        assertNull(result);

        expression = "abc";
        result = RPNCalculator.calculate(expression);
        assertNull(result);

        expression = "4%2+1";
        result = RPNCalculator.calculate(expression);
        assertEquals(1.0, result);

        expression = "4%-!8";
        result = RPNCalculator.calculate(expression);
        assertNull(result);
    }
}