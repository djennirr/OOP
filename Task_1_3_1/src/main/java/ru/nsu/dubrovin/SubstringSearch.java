package ru.nsu.dubrovin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Search for substring Class.
 */
public class SubstringSearch {

    public static void main(String[] args) {
    }

    /**
     * Searching for substring in file.
     *
     * @param fileName file in which we are searching.
     *
     * @param subString substring to search.
     *
     * @return arraylist of indices.
     *
     * @throws IOException exception can occur while searching for substring.
     *
     */
    public static ArrayList<Integer> find(String fileName, String subString) throws IOException {
        ArrayList<Integer> ret = new ArrayList<>();
        Reader reader;
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            ret = readerSearchForSubstring(reader, subString);
            return ret;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Searching for substring in reader.
     *
     * @param reader reader in which we are searching.
     *
     * @param subString substring to search.
     *
     * @return arraylist of indices.
     *
     * @throws IOException exception can occur while searching for substring.
     *
     */
    public static ArrayList<Integer> readerSearchForSubstring(Reader reader, String subString)
            throws IOException {
        ArrayList<Integer> indices = new ArrayList<>();
        int indice = 0;
        char c;
        int numc;
        int buffsize = subString.length();
        CircularBuffer buffer = new CircularBuffer(buffsize);

        for (int i = 0; i < buffsize; i++) {
            try {
                numc = reader.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (numc == -1) {
                return indices;
            }
            c = (char) numc;
            buffer.add(c);
        }

        if(Objects.equals(buffer.toString(), subString)) {
            indices.add(indice);
        }
        indice++;

        while ((numc = reader.read()) != -1) {
            c = (char) numc;
            buffer.add(c);

            if(Objects.equals(buffer.toString(), subString)) {
                indices.add(indice);
            }

            indice++;
        }

        return indices;
    }

    /**
     * Searching for substring in string.
     *
     * @param searchString string in which we are searching.
     *
     * @param subString substring to search.
     *
     * @return arraylist of indices.
     *
     * @throws IOException can occur while searching for substring.
     *
     */
    public static ArrayList<Integer> searchForSubstring(String searchString, String subString)
            throws IOException {
        Reader reader = new StringReader(searchString);
        return readerSearchForSubstring(reader, subString);
    }
}