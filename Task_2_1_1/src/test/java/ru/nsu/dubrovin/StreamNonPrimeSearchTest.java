package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreamNonPrimeSearchTest {
    //Tests for only prime numbers arrays.

    @Test
    void AllPrimesTest1() throws InterruptedException {
        StreamNonPrimeSearch search = new StreamNonPrimeSearch();
        int[] arr = new int[] {2, 3, 5, 7};
        assertEquals(search.containNotPrime(arr), false);
    }

    @Test
    void AllPrimesTest2() throws InterruptedException {
        StreamNonPrimeSearch search = new StreamNonPrimeSearch();
        int[] arr = new int[] {2, 3, 5, 7, 11, 13};
        assertEquals(search.containNotPrime(arr), false);
    }


    //Tests for not only prime numbers arrays.

    @Test
    void NotAllPrimesTest1() throws InterruptedException {
        StreamNonPrimeSearch search = new StreamNonPrimeSearch();
        int[] arr = new int[] {2, 3, 5, 7, 100};
        assertEquals(search.containNotPrime(arr), true);
    }

    @Test
    void NotAllPrimesTest2() throws InterruptedException {
        StreamNonPrimeSearch search = new StreamNonPrimeSearch();
        int[] arr = new int[] {2, 3, 5, 7, 11, 13, 100};
        assertEquals(search.containNotPrime(arr), true);
    }
}