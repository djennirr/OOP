package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PrimeCheckTest {
    @Test
    void testNegative() {
        assertEquals(false, PrimeCheck.isPrime(-1000));
    }

    @Test
    void testEqualToZero() {
        assertEquals(false, PrimeCheck.isPrime(0));
    }

    @Test
    void testEqualToOne() {
        assertEquals(false, PrimeCheck.isPrime(1));
    }

    @Test
    void testSmallPrime1() {
        assertEquals(true, PrimeCheck.isPrime(2));
    }

    @Test
    void testSmallPrime2() {
        assertEquals(true, PrimeCheck.isPrime(3));
    }

    @Test
    void testSmallNotPrime1() {
        assertEquals(false, PrimeCheck.isPrime(4));
    }

    @Test
    void testSmallNotPrime2() {
        assertEquals(false, PrimeCheck.isPrime(77));
    }

    @Test
    void testBigPrime1() {
        assertEquals(true, PrimeCheck.isPrime(33391));
    }

    @Test
    void testBigPrime2() {
        assertEquals(true, PrimeCheck.isPrime(115249));
    }

    @Test
    void testBigNotPrime1() {
        assertEquals(false, PrimeCheck.isPrime(33391 * 33391));
    }

    @Test
    void testBigNotPrime2() {
        assertEquals(false, PrimeCheck.isPrime(63949 * 63949));
    }

    @Test
    void testIntegerMin() {
        assertEquals(false, PrimeCheck.isPrime(Integer.MIN_VALUE));
    }

    @Test
    void testIntegerMax() {
        assertEquals(false, PrimeCheck.isPrime(Integer.MAX_VALUE));
    }
}