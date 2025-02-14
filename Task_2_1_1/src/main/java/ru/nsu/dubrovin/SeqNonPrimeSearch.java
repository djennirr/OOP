package ru.nsu.dubrovin;

/**
 * Class for sequential searching for non-prime number.
 */
public class SeqNonPrimeSearch implements PrimeSearchable {

    @Override
    public boolean containNotPrime(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (PrimeCheck.isPrime(arr[i]) == false) {
                return true;
            }
        }

        return false;
    }
}
