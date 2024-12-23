package ru.nsu.dubrovin;

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
    
}
