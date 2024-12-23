package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ImageTest {
    @Test
    void testImage() throws IOException {
        File file = new File("imageTest.md");
        FileWriter writer = new FileWriter(file);
        file.createNewFile();
        Image imageNoAltText = Image.builder().setLink("https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png").build();
        writer.append(imageNoAltText.toMarkDown());
        Image imageAltText = Image.builder().setLink("https://ic.pics.livejournal.com/chemodur/69177696/258350/258350_900.jpg").setAltText("whatever").build();
        writer.append("\n\n");
        writer.append(imageAltText.toMarkDown());
        writer.close();

        assertEquals(FileComparator.getDiffLineNumber(new File("imageTest.md"), new File(getClass().getResource("/image.md").getPath())), 0);
        file.delete();
    }
}