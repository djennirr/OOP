package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ImageTest {
    String resources = "src/test/resources/";
    @Test
    void test1() throws IOException {
        File file = new File("imageTest.md");
        FileWriter writer = new FileWriter(file);
        file.createNewFile();
        Image image = Image.builder().setLink("https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png").build();
        writer.append(image.toMarkDown());
        Image image2 = Image.builder().setLink("https://ic.pics.livejournal.com/chemodur/69177696/258350/258350_900.jpg").setAltText("whatever").build();
        writer.append("\n\n");
        writer.append(image2.toMarkDown());
        writer.close();

        assertEquals(FileComparator.getDiffLineNumber(new File("imageTest.md"), new File(resources + "image.md")), 0);
        file.delete();
    }
}