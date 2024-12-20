package ru.nsu.dubrovin;

/**
 * Class for exception occured in Parser.
 */
public class ParserException extends Exception {

    /**
     * Constructor.
     *
     * @param message description of exception.
     */
    public ParserException(String message) {
        super(message);
    }
}
