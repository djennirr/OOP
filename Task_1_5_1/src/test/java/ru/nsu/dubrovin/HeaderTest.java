package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeaderTest {
    String resources = "src/test/resources/";
    @Test
    void test1() throws Exception {
        Header header = Header.builder().setContent("Some text").setLevel(3).build();
        header.writeToFile(resources + "header.md");
    }
}