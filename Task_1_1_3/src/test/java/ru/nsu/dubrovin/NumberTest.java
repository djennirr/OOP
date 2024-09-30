package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    Number number = new Number(123);

    @Test
    void testEvaluate() {
        assertEquals(123, number.evaluate(""));
    }

    @Test
    void testDerivative() {
        assertEquals(0, number.derivative("").evaluate("x = 123"));
    }

    @Test
    void testToString() {
        assertEquals("123", number.toString());
    }
}