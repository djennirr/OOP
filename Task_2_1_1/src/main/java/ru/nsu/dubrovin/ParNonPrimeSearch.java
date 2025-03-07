package ru.nsu.dubrovin;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Class for thread-using searching for non-prime number.
 */
public class ParNonPrimeSearch implements PrimeSearchable {
    private final int threadsNumber;
    private AtomicBoolean flag = new AtomicBoolean(false);
    private int[] arr;

    /**
     * Constructor.
     *
     * @param threadsNumber number of threads user want to have.
     */
    public ParNonPrimeSearch(int threadsNumber) {
        this.threadsNumber = threadsNumber;
    }

    @Override
    public boolean containNotPrime(int[] arr) throws InterruptedException {
        this.arr = arr;

        if (arr.length == 0) {
            return false;
        }

        int realThreadsNumber = threadsNumber;

        if (realThreadsNumber >= arr.length) {
            realThreadsNumber = arr.length;
        }

        if (realThreadsNumber <= 0) {
            realThreadsNumber = 1;
        }

        Thread[] threads = new Thread[realThreadsNumber];

        int chunkSize = arr.length / realThreadsNumber;
        int remain = arr.length - chunkSize * realThreadsNumber;
        int chunkStart = 0;
        int chunkEnd;

        for (int i = 0; i < realThreadsNumber; i++) {
            chunkEnd = chunkStart + chunkSize;
            if (remain != 0) {
                chunkEnd++;
                remain--;
            }

            int finalChunkStart = chunkStart;
            int finalChunkEnd = chunkEnd;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = finalChunkStart; i < finalChunkEnd; i++) {
                        if (PrimeCheck.isPrime(arr[i]) == false) {
                            flag.set(true);
                        }
                    }
                }
            });

            chunkStart = chunkEnd;
        }

        for (int i = 0; i < realThreadsNumber; i++) {
            threads[i].start();
        }

        for (int i = 0; i < realThreadsNumber; i++) {
            threads[i].join();
        }

        return flag.get();
    }
}
