package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SubstringSearchTest {
    @Test
    void test1() throws IOException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(4);

        assertEquals(list, SubstringSearch.searchForSubstring("abaaaba", "aba"));
    }

    @Test
    void test2() throws IOException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);

        assertEquals(list, SubstringSearch.searchForSubstring("Ilovajava", "aja"));
    }

    @Test
    void test3() throws IOException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(20);
        list.add(22);
        list.add(24);

        assertEquals(list, SubstringSearch.searchForSubstring("Я не знаю че писать brbrbr aaa",
            "br"));
    }
}