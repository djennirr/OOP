package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

class MarkDownListTest {
    @Test
    void testCodeBlock() throws Exception {
        File file = new File("markDownTableTest.md");
        FileWriter writer = new FileWriter(file);
        file.createNewFile();
        MarkDownList markDownList = MarkDownList.builder().addLine("aaaa").addLine("bbbbb").setType(MarkDownList.ListType.USUAL).build();
        writer.append(markDownList.toMarkDown());
        writer.append("\n***\n");
        MarkDownList markDownList2 = MarkDownList.builder().addLine("aaa").addLine("bbb").setType(MarkDownList.ListType.NUMERATED).build();
        writer.append(markDownList2.toMarkDown());
        writer.append("\n***\n");
        Text boldItalic = Text.builder().setContent("Bold Italic").setBold(true).setItalic(true).build();
        Image image = Image.builder().setLink("https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png").build();
        MarkDownList markDownList3 = MarkDownList.builder().addLine(boldItalic.toMarkDown()).addLine(image.toMarkDown()).setType(MarkDownList.ListType.USUAL).build();
        writer.append(markDownList3.toMarkDown());
        writer.close();

        assertEquals(FileComparator.getDiffLineNumber(new File("markDownTableTest.md"), new File(getClass().getResource("/markDownTable.md").getPath())), 0);
        file.delete();
    }
}