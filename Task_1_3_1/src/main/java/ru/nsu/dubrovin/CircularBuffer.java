package ru.nsu.dubrovin;

import java.util.Arrays;

public class CircularBuffer {
    private int capacity;
    private Character[] buffer;
    private int ptr;

    public CircularBuffer(int capacity){
        this.capacity = capacity;
        this.buffer = new Character[capacity];
        this.ptr = 0;
    }

    public void add(char newChar){
        buffer[ptr] = newChar;
        ptr = (ptr + 1) % capacity;
    }

    public String toString(){
        char[] temp = new char[capacity];
        for (int i = 0; i < capacity; i++){
            temp[i] = buffer[(ptr + i) % capacity];
        }
        String ret = new String(temp);
        return ret;
    }
}
