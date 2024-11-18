package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SubstringSearchTest {
    @Test
    void test1StringSimple() throws IOException {
        ArrayList<Long> list = new ArrayList<Long>();
        list.add((long) 0);
        list.add((long) 4);

        assertEquals(list, SubstringSearch.searchForSubstring("abaaaba", "aba"));
    }

    @Test
    void test2StringSimple() throws IOException {
        ArrayList<Long> list = new ArrayList<Long>();
        list.add((long) 4);

        assertEquals(list, SubstringSearch.searchForSubstring("Ilovajava", "aja"));
    }

    @Test
    void test3StringRussianLanguage() throws IOException {
        ArrayList<Long> list = new ArrayList<Long>();
        list.add((long) 20);
        list.add((long) 22);
        list.add((long) 24);

        assertEquals(list, SubstringSearch.searchForSubstring("Я не знаю че писать brbrbr aaa",
            "br"));
    }

    @Test
    void test4StringJapaneseLanguage() throws IOException {
        ArrayList<Long> list = new ArrayList<Long>();
        list.add((long) 7);

        assertEquals(list, SubstringSearch.searchForSubstring("シド 『乱舞のメロディ』",
                "メ"));
    }

    @Test
    void test5StringJapaneseLanguage() throws IOException {
        ArrayList<Long> list = new ArrayList<Long>();
        list.add((long) 2);
        list.add((long) 15);
        list.add((long) 23);

        assertEquals(list, SubstringSearch.searchForSubstring(
            "走って転んで 消えない痛み抱いては 世界が待ってる この一瞬を","て"));
    }

    @Test
    void test6File() throws IOException {
        File file = new File("test.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.append("There is some text ahaha");
        fileWriter.close();

        ArrayList<Long> list = new ArrayList<Long>();
        list.add((long) 20);
        list.add((long) 22);

        assertEquals(list, SubstringSearch.find("test.txt", "ha"));

        file.delete();
    }

    @Test
    void test7File() throws IOException {
        File file = new File("test.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);

        for (int i = 0; i < 10; i++) {
            fileWriter.append("16characterline ");
        }

        fileWriter.append("*");
        fileWriter.close();

        ArrayList<Long> list = new ArrayList<Long>();
        boolean add = list.add((long) 10 * (long) 16);

        assertEquals(list, SubstringSearch.find("test.txt", "*"));

        file.delete();
    }

    @Test
    void test8FileExtreme() throws IOException {
        File file = new File("test.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);

        for (int i = 0; i < 1073741824; i++) {
            fileWriter.append("16characterline ");
        }

        fileWriter.append("*");
        fileWriter.close();

        ArrayList<Long> list = new ArrayList<Long>();
        boolean add = list.add((long) 1073741824 * (long) 16);

        assertEquals(list, SubstringSearch.find("test.txt", "*"));

        file.delete();
    }
}