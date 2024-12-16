package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.rmi.server.ExportException;

class ParserTest {
    Parser parser = new Parser();

    @Test
    void testVariable() throws Exception {
        assertEquals(parser.parseExpr("aaa").toString(), "aaa");
        Exception e = assertThrows(Exception.class, () -> parser.parseExpr(""));
        assertEquals("Empty expression", e.getMessage());
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
        Exception e = assertThrows(Exception.class, () -> parser.parseExpr("((((("));
        assertEquals("Inappropriate brackets sequence", e.getMessage());
    }
}