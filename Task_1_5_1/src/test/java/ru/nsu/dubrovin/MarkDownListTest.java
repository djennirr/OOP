package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class MarkDownListTest {
    @Test
    void testCodeBlock() throws IOException {
        File file = new File("markDownListTest.md");
        FileWriter writer = new FileWriter(file);
        file.createNewFile();

        MarkDownList markDownList = MarkDownList.builder().addLine("aaaa").addLine("bbbbb")
            .setType(MarkDownList.ListType.USUAL).build();
        writer.append(markDownList.toMarkDown());
        writer.append("\n***\n");

        MarkDownList markDownList2 = MarkDownList.builder().addLine("aaa").addLine("bbb")
            .setType(MarkDownList.ListType.NUMERATED).build();
        writer.append(markDownList2.toMarkDown());
        writer.append("\n***\n");

        Text boldItalic = Text.builder().setContent("Bold Italic").setBold(true).setItalic(true)
            .build();
        Image image = Image.builder().setLink("https://github.com/adam-p/markdown-here/raw/"
            + "master/src/common/images/icon48.png").build();
        MarkDownList markDownList3 = MarkDownList.builder().addLine(boldItalic.toMarkDown())
            .addLine(image.toMarkDown()).setType(MarkDownList.ListType.USUAL).build();
        writer.append(markDownList3.toMarkDown());
        writer.close();

        assertEquals(FileComparator.getDiffLineNumber(new File("markDownListTest.md"),
            new File(getClass().getResource("/markDownList.md").getPath())), 0);
        file.delete();
    }

    @Test
    void testEquals() {
        MarkDownList markDownList1 = MarkDownList.builder().addLine("aaa").addLine("bbb")
            .setType(MarkDownList.ListType.NUMERATED).build();
        MarkDownList markDownList2 = MarkDownList.builder().addLine("aaa").addLine("bbb")
            .setType(MarkDownList.ListType.NUMERATED).build();
        MarkDownList markDownList3 = MarkDownList.builder().addLine("aaa").addLine("bbb")
            .setType(MarkDownList.ListType.USUAL).build();

        assertEquals(markDownList1.equals(markDownList2), true);
        assertEquals(markDownList1.equals(markDownList3), false);
    }

    @Test
    void testExceptions() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> MarkDownList.builder()
            .build().toMarkDown());
        assertEquals("No lines specified", e.getMessage());

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> MarkDownList.builder()
            .addLine("a").addLine("b").build().toMarkDown());
        assertEquals("No list type specified", e2.getMessage());
    }
}