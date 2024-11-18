package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SubstringSearchTest {
    @Test
    void test(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(4);

        assertEquals(list, SubstringSearch.searchForSubstring("abaaaba", "aba"));
    }
}