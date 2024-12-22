package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {
    String resources = "src/test/resources/";
    @Test
    void test1() throws IOException {
        File file = new File("linkTest.md");
        FileWriter writer = new FileWriter(file);
        file.createNewFile();
        Link link = Link.builder().setLink("google.com").build();
        writer.append(link.toMarkDown());
        Link link2 = Link.builder().setLink("google.com").setName("Google").build();
        writer.append("\n\n");
        writer.append(link2.toMarkDown());
        writer.close();

        assertEquals(FileComparator.getDiffLineNumber(new File("linkTest.md"), new File(resources + "link.md")), 0);
        file.delete();
    }
}