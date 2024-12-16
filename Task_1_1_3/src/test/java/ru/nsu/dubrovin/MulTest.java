package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MulTest {
    Mul firstMul = new Mul(new Number(42), new Number(69));
    Mul secondMul = new Mul(new Number(42), new Variable("y"));
    Mul thirdMul = new Mul(new Variable("x"), new Variable("y"));

    @Test
    void testEvaluate() throws Exception {
        assertEquals(2898, firstMul.evaluate(""));
        assertEquals(2898, secondMul.evaluate("y = 69"));
        assertEquals(2898, thirdMul.evaluate("x = 42; y = 69"));
    }

    @Test
    void derivative() throws Exception {
        assertEquals(0, firstMul.derivative("x").evaluate(""));
        assertEquals(42, secondMul.derivative("y").evaluate("y = 1"));
        assertEquals(0, secondMul.derivative("x").evaluate("y = 123"));
        assertEquals(10, thirdMul.derivative("y").evaluate("y = 10; x = 10"));
    }

    @Test
    void testToString() {
        assertEquals("(42*69)", firstMul.toString());
        assertEquals("(42*y)", secondMul.toString());
        assertEquals("(x*y)", thirdMul.toString());
    }
}