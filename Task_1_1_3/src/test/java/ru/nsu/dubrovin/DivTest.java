package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DivTest {
    Div firstDiv = new Div(new Number(4), new Number(2));
    Div secondDiv = new Div(new Number(4), new Variable("y"));
    Div thirdDiv = new Div(new Variable("x"), new Variable("y"));

    @Test
    void testEvaluate() throws Exception {
        assertEquals(2, firstDiv.evaluate(""));
        assertEquals(2, secondDiv.evaluate("y = 2"));
        assertEquals(2, thirdDiv.evaluate("x = 4; y = 2"));
        Div de = new Div(new Variable("var"), new Number(0));
        Exception e = assertThrows(ArithmeticException.class, () -> de.evaluate(""));
        assertEquals("Division by 0", e.getMessage());
    }

    @Test
    void derivative() throws Exception {
        assertEquals(0, firstDiv.derivative("x").evaluate("x = 4; y = 2"));
        assertEquals(-1, secondDiv.derivative("y").evaluate("x = 4; y = 2"));
        assertEquals(0, secondDiv.derivative("x").evaluate("x = 4; y = 2"));
        assertEquals(-1, thirdDiv.derivative("y").evaluate("x = 4; y = 2"));
    }

    @Test
    void testToString() {
        assertEquals("(4/2)", firstDiv.toString());
        assertEquals("(4/y)", secondDiv.toString());
        assertEquals("(x/y)", thirdDiv.toString());
    }

    @Test
    void testSimplify() throws Exception {
        assertEquals(firstDiv.simplify().evaluate(""), 2);
        Number zer = new Number(0);
        Number one = new Number(1);
        Variable var = new Variable("zero");
        Div dz = new Div(zer, var);
        Div dvo = new Div(var, one);
        assertEquals(dz.simplify().toString(), zer.toString());
        assertEquals(dvo.simplify().toString(), var.toString());
        Div de = new Div(new Variable("var"), new Number(0));
        Exception e = assertThrows(ArithmeticException.class, () -> de.simplify());
        assertEquals("Division by 0", e.getMessage());
    }
}