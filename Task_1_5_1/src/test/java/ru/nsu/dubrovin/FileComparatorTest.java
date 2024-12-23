package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class FileComparatorTest {
    @Test
    void comparatorTest() throws IOException {
        File text = new File(getClass().getResource("/text.md").getPath());
        File image = new File(getClass().getResource("/image.md").getPath());

        assertEquals(FileComparator.getDiffLineNumber(text, text), 0);
        assertEquals(FileComparator.getDiffLineNumber(text, image), 1);
    }
}