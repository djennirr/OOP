package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

class CodeBlockTest {
    String resources = "src/test/resources/";
    @Test
    void testCodeBlock() throws Exception {
        File file = new File("codeBlockTest.md");
        FileWriter writer = new FileWriter(file);
        file.createNewFile();
        CodeBlock codeBlock = CodeBlock.builder().setContent("#include <stdio.h>\n#include <stdlib.h>\n").setLanguage("C").build();
        writer.append(codeBlock.toMarkDown());
        writer.append("\n\n");
        CodeBlock codeBlock2 = CodeBlock.builder().setContent("There is no language specified\nSo, whatever").build();
        writer.append(codeBlock2.toMarkDown());
        writer.close();

        assertEquals(FileComparator.getDiffLineNumber(new File("codeBlockTest.md"), new File(getClass().getResource("/codeBlock.md").getPath())), 0);
        file.delete();
    }
}