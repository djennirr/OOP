package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class VariableTest {
    Variable variable = new Variable("myIQ");

    @Test
    void testEvaluate() throws Exception {
        assertEquals(10, variable.evaluate("stenenkoIQ = 1000; myIQ = 10"));
        Exception e = assertThrows(VariableException.class, () -> variable.evaluate(""));
        assertEquals("Cannot evaluate", e.getMessage());
    }

    @Test
    void testDerivative() throws Exception {
        assertEquals(1, variable.derivative("myIQ").evaluate(""));
        assertEquals(0, variable.derivative("stenenkoIQ").evaluate(""));
    }

    @Test
    void testToString() {
        assertEquals("myIQ", variable.toString());
    }

    @Test
    void testSimplify() {
        assertEquals(variable.simplify(), variable);
    }
}