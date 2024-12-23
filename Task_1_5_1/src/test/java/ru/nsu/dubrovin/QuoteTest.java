package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class QuoteTest {
    @Test
    void testQuote() throws IOException {
        File file = new File("quoteTest.md");
        FileWriter writer = new FileWriter(file);
        file.createNewFile();

        Quote quote = Quote.builder().setContent("Some quote").build();
        writer.append(quote.toMarkDown());
        writer.append("\n\n");

        Quote quote2 = Quote.builder().setContent("Yet another clever quote").build();
        writer.append(quote2.toMarkDown());
        writer.close();

        assertEquals(FileComparator.getDiffLineNumber(new File("quoteTest.md"),
            new File(getClass().getResource("/quote.md").getPath())), 0);
        file.delete();
    }

    @Test
    void testEquals() {
        Quote quote1 = Quote.builder().setContent("aa").build();
        Quote quote2 = Quote.builder().setContent("aa").build();
        Quote quote3 = Quote.builder().setContent("aaaa").build();

        assertEquals(quote1.equals(quote2), true);
        assertEquals(quote1.equals(quote3), false);
    }

    @Test
    void testExceptions() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> Quote.builder()
            .build().toMarkDown());
        assertEquals("No content specified", e.getMessage());
    }
}