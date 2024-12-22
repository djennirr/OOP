package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TextTest {
    String resources = "src/test/resources/";
    @Test
    void test1() throws IOException {
        Text text = Text.builder().setContent("Aboba").setBold(true).setItalic(true).build();
        text.writeToFile(resources + "aboba.md");
    }
}