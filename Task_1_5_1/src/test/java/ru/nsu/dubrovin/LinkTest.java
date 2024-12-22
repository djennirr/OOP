package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {
    String resources = "src/test/resources/";
    @Test
    void test1() throws IOException {
        Link link = Link.builder().setLink("google.com").build();
        link.writeToFile(resources + "link.md");
        Link link2 = Link.builder().setLink("google.com").setName("Google").build();
        link2.writeToFile(resources + "link2.md");
    }
}