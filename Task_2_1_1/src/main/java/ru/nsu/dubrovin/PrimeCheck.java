package ru.nsu.dubrovin;

/**
 * Class for primarity checking
 */

public class PrimeCheck {
    /**
     * method, checking whether is the given number prime.
     *
     * @param number number to check.
     *
     * @return true if number is prime, false if nor.
     */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
