package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SubTest {
    Sub firstDiff = new Sub(new Number(42), new Number(69));
    Sub secondDiff = new Sub(new Number(42), new Variable("y"));
    Sub thirdDiff = new Sub(new Variable("x"), new Variable("y"));

    @Test
    void testEvaluate() throws Exception {
        assertEquals(-27, firstDiff.evaluate(""));
        assertEquals(-27, secondDiff.evaluate("y = 69"));
        assertEquals(-27, thirdDiff.evaluate("x = 42; y = 69"));
    }

    @Test
    void derivative() throws Exception {
        assertEquals(0, firstDiff.derivative("x").evaluate(""));
        assertEquals(1, secondDiff.derivative("y").evaluate(""));
        assertEquals(0, secondDiff.derivative("x").evaluate(""));
        assertEquals(1, thirdDiff.derivative("y").evaluate(""));
    }

    @Test
    void testToString() {
        assertEquals("(42-69)", firstDiff.toString());
        assertEquals("(42-y)", secondDiff.toString());
        assertEquals("(x-y)", thirdDiff.toString());
    }
}