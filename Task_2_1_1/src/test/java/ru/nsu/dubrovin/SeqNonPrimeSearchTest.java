package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SeqNonPrimeSearchTest {
    //Tests for only prime numbers arrays.

    @Test
    void allPrimesTest1() {
        SeqNonPrimeSearch search = new SeqNonPrimeSearch();
        int[] arr = new int[] {2, 3, 5, 7};
        assertEquals(search.containNotPrime(arr), false);
    }

    @Test
    void allPrimesTest2() {
        SeqNonPrimeSearch search = new SeqNonPrimeSearch();
        int[] arr = new int[] {2, 3, 5, 7, 11, 13};
        assertEquals(search.containNotPrime(arr), false);
    }


    //Tests for not only prime numbers arrays.

    @Test
    void notAllPrimesTest1() {
        SeqNonPrimeSearch search = new SeqNonPrimeSearch();
        int[] arr = new int[] {2, 3, 5, 7, 100};
        assertEquals(search.containNotPrime(arr), true);
    }

    @Test
    void notAllPrimesTest2() {
        SeqNonPrimeSearch search = new SeqNonPrimeSearch();
        int[] arr = new int[] {2, 3, 5, 7, 11, 13, 100};
        assertEquals(search.containNotPrime(arr), true);
    }
}