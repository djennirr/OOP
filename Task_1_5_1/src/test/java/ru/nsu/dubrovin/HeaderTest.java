package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeaderTest {
    @Test
    void testHeader() throws Exception {
        File file = new File("headerTest.md");
        FileWriter writer = new FileWriter(file);
        file.createNewFile();

        Header header3Level = Header.builder().setContent("Some text").setLevel(3).build();
        writer.append(header3Level.toMarkDown());
        writer.append("\n\n");

        Header header2Level = Header.builder().setContent("Some smaller text").setLevel(6).build();
        writer.append(header2Level.toMarkDown());
        writer.close();

        assertEquals(FileComparator.getDiffLineNumber(new File("headerTest.md"), new File(getClass().getResource("/header.md").getPath())), 0);
        file.delete();
    }

    @Test
    void testEquals() {
        Header header1 = Header.builder().setContent("aa").setLevel(3).build();
        Header header2 = Header.builder().setContent("aa").setLevel(3).build();
        Header header3 = Header.builder().setContent("aa").setLevel(6).build();

        assertEquals(header1.equals(header2), true);
        assertEquals(header1.equals(header3), false);
    }
}