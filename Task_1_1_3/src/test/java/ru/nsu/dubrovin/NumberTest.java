package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NumberTest {
    Number number = new Number(123);

    @Test
    void testEvaluate() throws Exception {
        assertEquals(123, number.evaluate(""));
    }

    @Test
    void testDerivative() throws Exception {
        assertEquals(0, number.derivative("").evaluate("x = 123"));
    }

    @Test
    void testToString() {
        assertEquals("123", number.toString());
    }

    @Test
    void testSimplify() {
        assertEquals(number.simplify(), number);
    }
}