package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SubstringSearchTest {
    @Test
    void test() throws IOException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(4);

        assertEquals(list, SubstringSearch.searchForSubstring("abaaaba", "aba"));
    }
}