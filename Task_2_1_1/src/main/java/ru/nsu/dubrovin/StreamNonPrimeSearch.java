package ru.nsu.dubrovin;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Class for parllel-streams-using searching for non-prime number.
 */
public class StreamNonPrimeSearch implements PrimeSearchable {
    @Override
    public boolean containNotPrime(int[] arr) throws InterruptedException {
        IntStream numberStream =  Arrays.stream(arr);
        return ! numberStream.parallel().allMatch(PrimeCheck::isPrime);
    }
}
