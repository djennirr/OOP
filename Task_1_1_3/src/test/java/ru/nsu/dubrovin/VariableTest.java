package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariableTest {
    Variable variable = new Variable("myIQ");

    @Test
    void testEvaluate() {
        assertEquals(10, variable.evaluate("stenenkoIQ = 1000; myIQ = 10"));
    }

    @Test
    void testDerivative() {
        assertEquals(1, variable.derivative("myIQ").evaluate(""));
        assertEquals(0, variable.derivative("stenenkoIQ").evaluate(""));
    }

    @Test
    void testToString() {
        assertEquals("myIQ", variable.toString());
    }
}