package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

class HeaderTest {
    @Test
    void testHeader() throws Exception {
        File file = new File("headerTest.md");
        FileWriter writer = new FileWriter(file);
        file.createNewFile();
        Header header = Header.builder().setContent("Some text").setLevel(3).build();
        writer.append(header.toMarkDown());
        writer.append("\n\n");
        Header header2 = Header.builder().setContent("Some smaller text").setLevel(6).build();
        writer.append(header2.toMarkDown());
        writer.close();

        assertEquals(FileComparator.getDiffLineNumber(new File("headerTest.md"), new File(getClass().getResource("/header.md").getPath())), 0);
        file.delete();
    }
}