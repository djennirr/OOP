package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class LinkTest {
    @Test
    void testLink() throws IOException {
        File file = new File("linkTest.md");
        try (FileWriter writer = new FileWriter(file);) {
            file.createNewFile();

            Link linkNoName = Link.builder().setLink("https://google.com").build();
            writer.append(linkNoName.toMarkDown());
            writer.append("\n\n");

            Link linkNamed = Link.builder().setLink("https://google.com").setName("Google")
                .build();
            writer.append(linkNamed.toMarkDown());
            writer.close();

            assertEquals(FileComparator.getDiffLineNumber(new File("linkTest.md"),
                new File(getClass().getResource("/link.md").getPath())), 0);
        } finally {
            file.delete();
        }
    }

    @Test
    void testEquals() {
        Link link1 = Link.builder().setName("aa").setLink("bb").build();
        Link link2 = Link.builder().setName("aa").setLink("bb").build();
        Link link3 = Link.builder().setName("aa").build();

        assertEquals(link1.equals(link2), true);
        assertEquals(link1.equals(link3), false);
    }

    @Test
    void testExceptions() {
        Exception empty = assertThrows(IllegalArgumentException.class, () -> Link.builder().build()
            .toMarkDown());
        assertEquals("No link specified", empty.getMessage());
    }
}