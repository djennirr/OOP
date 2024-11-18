package ru.nsu.dubrovin;

/**
 * Not quite circular buffer, but i have no clue how to name this staff.
 */
public class CircularBuffer {
    private int capacity;
    private Character[] buffer;
    private int ptr;

    /**
     * Constructor.
     *
     * @param capacity size of the buffer.
     */
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new Character[capacity];
        this.ptr = 0;
    }

    /**
     * Adding new char and moving pointer.
     *
     * @param newChar character to add.
     */
    public void add(char newChar) {
        buffer[ptr] = newChar;
        ptr = (ptr + 1) % capacity;
    }

    /**
     * Returns string the buffer contains.
     *
     * @return string.
     */
    @Override
    public String toString() {
        char[] temp = new char[capacity];
        for (int i = 0; i < capacity; i++) {
            temp[i] = buffer[(ptr + i) % capacity];
        }
        String ret = new String(temp);
        System.out.println(ret);
        return ret;
    }
}
