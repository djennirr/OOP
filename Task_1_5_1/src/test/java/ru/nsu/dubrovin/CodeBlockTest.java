package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

class CodeBlockTest {
    @Test
    void testCodeBlock() throws Exception {
        File file = new File("codeBlockTest.md");
        FileWriter writer = new FileWriter(file);
        file.createNewFile();
        CodeBlock codeBlockHighlighted = CodeBlock.builder().setContent("#include <stdio.h>\n#include <stdlib.h>\n").setLanguage("C").build();
        writer.append(codeBlockHighlighted.toMarkDown());
        writer.append("\n\n");
        CodeBlock codeBlockUnHighLighted = CodeBlock.builder().setContent("There is no language specified\nSo, whatever").build();
        writer.append(codeBlockUnHighLighted.toMarkDown());
        writer.close();

        assertEquals(FileComparator.getDiffLineNumber(new File("codeBlockTest.md"), new File(getClass().getResource("/codeBlock.md").getPath())), 0);
        file.delete();
    }
}