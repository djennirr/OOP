package ru.nsu.dubrovin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class for file line by line comparator.
 */
public class FileComparator {
    /**
     * Compares contents of 2 files line by line.
     *
     * @param file1 first file to compare.
     *
     * @param file2 second file to compare.
     *
     * @return 0 if files are containing same content, otherwise number of first different line.
     *
     * @throws IOException if cannot read from file.
     */
    public static long getDiffLineNumber(File file1, File file2) throws IOException {
        BufferedReader bf1 = new BufferedReader(new FileReader(file1));
        BufferedReader bf2 = new BufferedReader(new FileReader(file2));
        long lineNumber = 1;
        String line1 = "";
        String line2 = "";
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
        } else {
            return lineNumber;
        }
    }
}
