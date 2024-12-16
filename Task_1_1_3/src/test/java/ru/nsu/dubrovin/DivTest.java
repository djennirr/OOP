package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DivTest {
    Div firstDiv = new Div(new Number(52), new Number(26));
    Div secondDiv = new Div(new Number(52), new Variable("y"));
    Div thirdDiv = new Div(new Variable("x"), new Variable("y"));

    @Test
    void testEvaluate() throws Exception {
        assertEquals(2, firstDiv.evaluate(""));
        assertEquals(2, secondDiv.evaluate("y = 69"));
        assertEquals(2, thirdDiv.evaluate("x = 42; y = 69"));
    }

    @Test
    void derivative() throws Exception {
        assertEquals(0, firstDiv.derivative("x").evaluate(""));
        assertEquals(1, secondDiv.derivative("y").evaluate(""));
        assertEquals(0, secondDiv.derivative("x").evaluate(""));
        assertEquals(1, thirdDiv.derivative("y").evaluate(""));
    }

    @Test
    void testToString() {
        assertEquals("(42/69)", firstDiv.toString());
        assertEquals("(42/y)", secondDiv.toString());
        assertEquals("(x/y)", thirdDiv.toString());
    }
}