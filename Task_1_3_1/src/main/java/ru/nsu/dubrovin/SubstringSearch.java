package ru.nsu.dubrovin;

import java.io.IOException;
import java.io.Reader;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Objects;


public class SubstringSearch {

    public static void main(String[] args) {
    }

    public static ArrayList<Integer> find(String fileName, String subString) throws IOException {
        Reader reader = new FileReader(fileName);
        return readerSearchForSubstring(reader, subString);
    }

    public static ArrayList<Integer> readerSearchForSubstring(Reader reader, String subString) throws IOException
    {
        ArrayList<Integer> indices = null;
        int indice = 0;
        char c;
        int numc;
        int buffsize = subString.length();
        CircularBuffer buffer = new CircularBuffer(buffsize);

        for (int i = 0; i < buffsize; i++){
            numc = reader.read();
            if (numc == -1){
                return indices;
            }
            c = (char) numc;
            buffer.add(c);
        }

        if(Objects.equals(buffer.toString(), subString)){
            indices.add(indice);
        }

        while ((numc = reader.read()) != -1){
            c = (char) numc;
            buffer.add(c);

            if(Objects.equals(buffer.toString(), subString)){
                indices.add(indice);
            }
        }

        return indices;
    }

    public static ArrayList<Integer> searchForSubstring(String searchString, String subString) throws IOException {
        Reader reader = new StringReader(searchString);
        return readerSearchForSubstring(reader, subString);
    }
}