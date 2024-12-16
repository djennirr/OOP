package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ParserTest {
    Parser parser = new Parser();

    @Test
    void testVariable() throws Exception {
        assertEquals(parser.parseExpr("aaa").toString(), "aaa");
    }

    @Test
    void testNumber() throws Exception {
        assertEquals(parser.parseExpr("1").toString(), "1");
    }

    @Test
    void testEval() throws Exception {
        assertEquals(parser.parseExpr("1 + 1").evaluate(""), 2);
        assertEquals(parser.parseExpr("a + b - c").evaluate("a = 100; b = 3; c = 81"), 22);
    }

    @Test
    void testBrackets() throws Exception {
        assertEquals(parser.parseExpr("((((1 + 1)) + 1))").evaluate(""), 3);
        assertEquals(parser.parseExpr("(2 + 2) * 2").evaluate(""), 8);
        assertEquals(parser.parseExpr("(((((1)))))").evaluate(""), 1);
    }
}