package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {
    @Test
    void testLink() throws IOException {
        File file = new File("linkTest.md");
        FileWriter writer = new FileWriter(file);
        file.createNewFile();
        Link linkNoName = Link.builder().setLink("https://google.com").build();
        writer.append(linkNoName.toMarkDown());
        Link linkNamed = Link.builder().setLink("https://google.com").setName("Google").build();
        writer.append("\n\n");
        writer.append(linkNamed.toMarkDown());
        writer.close();

        assertEquals(FileComparator.getDiffLineNumber(new File("linkTest.md"), new File(getClass().getResource("/link.md").getPath())), 0);
        file.delete();
    }
}