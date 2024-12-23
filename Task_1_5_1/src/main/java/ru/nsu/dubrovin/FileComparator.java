package ru.nsu.dubrovin;

import java.io.*;

public class FileComparator {
    public static long getDiffLineNumber(File file1, File file2) throws IOException {
        BufferedReader bf1 = new BufferedReader(new FileReader(file1));
        BufferedReader bf2 = new BufferedReader(new FileReader(file2));
        long lineNumber = 1;
        String line1 = "", line2 = "";
        while ((line1 = bf1.readLine()) != null) {
            line2 = bf2.readLine();
            if (line2 == null || !line1.equals(line2)) {
                System.err.println(line1);
                System.err.println(line2);
                return lineNumber;
            }
            lineNumber++;
        }
        if (bf2.readLine() == null) {
            return 0;
        }
        else {
            return lineNumber;
        }
    }
}

