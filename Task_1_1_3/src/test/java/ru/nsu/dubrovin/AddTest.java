package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {
    Add firstSum = new Add(new Number(42), new Number(69));
    Add secondSum = new Add(new Number(42), new Variable("y"));
    Add thirdSum = new Add(new Variable("x"), new Variable("y"));

    @Test
    void testEvaluate() throws Exception {
        assertEquals(111, firstSum.evaluate(""));
        assertEquals(111, secondSum.evaluate("y = 69"));
        assertEquals(111, thirdSum.evaluate("x = 42; y = 69"));
    }

    @Test
    void derivative() throws Exception {
        assertEquals(0, firstSum.derivative("x").evaluate(""));
        assertEquals(1, secondSum.derivative("y").evaluate(""));
        assertEquals(0, secondSum.derivative("x").evaluate(""));
        assertEquals(1, thirdSum.derivative("y").evaluate(""));
    }

    @Test
    void testToString() {
        assertEquals("(42+69)", firstSum.toString());
        assertEquals("(42+y)", secondSum.toString());
        assertEquals("(x+y)", thirdSum.toString());
    }
}