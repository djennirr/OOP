package ru.nsu.dubrovin;

/*import java.io.File;
import java.io.FileWriter;
import java.io.IOException;*/

/**
 * Abstract class for markdown elements.
 */
public abstract class Element {

    /**
     * Serializes object into string.
     *
     * @return md string.
     */
    public abstract String toMarkDown();

    /*public void writeToFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.append(this.toMarkDown());
        fileWriter.close();
    }*/
}