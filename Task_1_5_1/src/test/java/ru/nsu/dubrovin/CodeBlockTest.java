package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class CodeBlockTest {
    @Test
    void testCodeBlock() throws IOException {
        File file = new File("codeBlockTest.md");
        try (FileWriter writer = new FileWriter(file);) {
            file.createNewFile();

            CodeBlock codeBlockHighlighted = CodeBlock.builder().setContent("#include <stdio.h>\n"
                    + "#include <stdlib.h>\n").setLanguage("C").build();
            writer.append(codeBlockHighlighted.toMarkDown());
            writer.append("\n\n");

            CodeBlock codeBlockUnHighLighted = CodeBlock.builder().setContent("There is no "
                    + "language specified\nSo, whatever").build();
            writer.append(codeBlockUnHighLighted.toMarkDown());
            writer.close();

            assertEquals(FileComparator.getDiffLineNumber(new File("codeBlockTest.md"),
                    new File(getClass().getResource("/codeBlock.md").getPath())), 0);
        } finally {
            file.delete();
        }
    }

    @Test
    void testEquals() {
        CodeBlock codeBlock1 = CodeBlock.builder().setContent("int a = 1;")
            .setLanguage("C").build();
        CodeBlock codeBlock2 = CodeBlock.builder().setContent("int a = 1;")
            .setLanguage("C").build();
        CodeBlock codeBlock3 = CodeBlock.builder().setContent("int a = 1;")
            .setLanguage("Java").build();

        assertEquals(codeBlock1.equals(codeBlock2), true);
        assertEquals(codeBlock1.equals(codeBlock3), false);
    }

    @Test
    void testExceptions() {
        Exception empty = assertThrows(IllegalArgumentException.class, () -> CodeBlock.builder()
            .build().toMarkDown());
        assertEquals("No content specified", empty.getMessage());
    }
}