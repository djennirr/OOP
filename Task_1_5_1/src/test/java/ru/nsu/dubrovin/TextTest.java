package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TextTest {
    @Test
    void testText() throws IOException {
        File file = new File("textTest.md");
        FileWriter writer = new FileWriter(file);
        file.createNewFile();
        Text boldItalic = Text.builder().setContent("Bold Italic").setBold(true).setItalic(true).build();
        writer.append(boldItalic.toMarkDown());
        writer.append("\n\n");
        Text code = Text.builder().setContent("#include <stdio.h>").setCode(true).build();
        writer.append(code.toMarkDown());
        writer.append("\n\n");
        Text lie = Text.builder().addContent("I ").addContent("Love ").addContent("python").setStrikeThrough(true).build();
        writer.append(lie.toMarkDown());
        writer.close();

        assertEquals(FileComparator.getDiffLineNumber(new File("textTest.md"), new File(getClass().getResource("/text.md").getPath())), 0);
        file.delete();
    }
}