package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CowParserTest {
    CowParser parser = new CowParser();

    @Test
    void testVariable() throws Exception {
        assertEquals(parser.parseExpr("aaa").toString(), "aaa");
        Exception empty = assertThrows(ParserException.class, () -> parser.parseExpr(""));
        assertEquals("Empty expression", empty.getMessage());
        Exception args = assertThrows(ParserException.class, () -> parser.parseExpr("1+"));
        assertEquals("Not enough arguments", args.getMessage());
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
        assertEquals(parser.parseExpr("(90 / ((111 / 3) - 7)) * 2").evaluate(""), 6);
        Exception e = assertThrows(ParserException.class, () -> parser.parseExpr("((((("));
        assertEquals("Inappropriate brackets sequence", e.getMessage());
        // Then some without brackets
        assertEquals(parser.parseExpr("5 - 1 + 7").evaluate(""), 11);
        assertEquals(parser.parseExpr("2 + 2 * 2").evaluate(""), 6);
        assertEquals(parser.parseExpr("2 * 2 + 2").evaluate(""), 6);
    }

    @Test
    void testBigExpressions() throws Exception {
        assertEquals(parser.parseExpr("((123 * 11) / 3) + (((111 / 3) - 7) * 2)").evaluate(""),
                511);
        assertEquals(parser.parseExpr("(9831 / 29) + ((18 * 126) - 4)").evaluate(""), 2603);
        assertEquals(parser.parseExpr("((2491 / 53) - (83891 * 34)) + (383 * 416)").evaluate(""),
                -2692919);
    }

    @Test
    void testSimplify() throws Exception {
        assertEquals(parser.parseExpr("((x * 0) + (a - a))").simplify().evaluate(""), 0);
        assertEquals(parser.parseExpr("((a + 0) * (x - x)) + 3").simplify().evaluate(""), 3);
    }
}