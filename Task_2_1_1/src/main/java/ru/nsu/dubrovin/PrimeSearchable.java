package ru.nsu.dubrovin;

/**
 * Interface for classes to search for not prime numbers.
 */
public interface PrimeSearchable {

    /**
     * cheking if the array contains non-ptime number.
     *
     * @return true if there is any non-prime number, else false.
     */
    public boolean containNotPrime(int[] arr) throws InterruptedException;
}
