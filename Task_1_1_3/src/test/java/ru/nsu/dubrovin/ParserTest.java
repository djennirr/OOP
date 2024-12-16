package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {
    Parser parser = new Parser();

    @Test
    void parserTest1() throws Exception {
        assertEquals(parser.parseExpr("aaa").toString(), "aaa");
    }

    @Test
    void parserTest2() throws Exception {
        assertEquals(parser.parseExpr("1").toString(), "1");
    }

    @Test
    void parserTest3() throws Exception {
        assertEquals(parser.parseExpr("1 + 1").evaluate(""), 2);
    }

    @Test
    void parserTest4() throws Exception {
        assertEquals(parser.parseExpr("((((1 + 1)) + 1))").evaluate(""), 3);
    }
}