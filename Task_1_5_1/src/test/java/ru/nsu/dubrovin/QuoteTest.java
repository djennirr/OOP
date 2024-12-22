package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

class QuoteTest {
    String resources = "src/test/resources/";
    @Test
    void test1() throws Exception {
        File file = new File("quoteTest.md");
        FileWriter writer = new FileWriter(file);
        file.createNewFile();
        Quote quote = Quote.builder().setContent("Some quote").build();
        writer.append(quote.toMarkDown());
        writer.append("\n\n");
        Quote quote2 = Quote.builder().setContent("Yet another clever quote").build();
        writer.append(quote2.toMarkDown());
        writer.close();

        assertEquals(FileComparator.getDiffLineNumber(new File("quoteTest.md"), new File(resources + "quote.md")), 0);
        file.delete();
    }
}