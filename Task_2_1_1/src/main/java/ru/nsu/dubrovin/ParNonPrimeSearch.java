package ru.nsu.dubrovin;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Class for thread-using searching for non-prime number.
 */
public class ParNonPrimeSearch implements PrimeSearchable {
    private final int threadsNumber;
    private AtomicBoolean flag = new AtomicBoolean(false);

    /**
     * Constructor.
     *
     * @param threadsNumber number of threads user want to have.
     */
    public ParNonPrimeSearch (int threadsNumber) {
        this.threadsNumber = threadsNumber;
    }

    private class Task implements Runnable {
        private final int[] chunk;

        private Task(int[] chunk) {
            this.chunk = chunk;
        }

        @Override
        public void run() {
            for (int i = 0; i < chunk.length; i++) {
                if (PrimeCheck.isPrime(chunk[i]) == false) {
                    flag.set(true);
                }
            }
        }
    }

    @Override
    public boolean containNotPrime(int[] arr) throws InterruptedException {
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
        int[] chunk;

        for (int i = 0; i < realThreadsNumber; i++) {
            chunkEnd = chunkStart + chunkSize;
            if (remain != 0) {
                chunkEnd++;
                remain--;
            }

            chunk = Arrays.copyOfRange(arr, chunkStart, chunkEnd);
            chunkStart = chunkEnd;
            threads[i] = new Thread(new Task(chunk));
        }

        for (int i = 0; i < realThreadsNumber; i++) {
            threads[i].start();
            threads[i].join();
        }
        return flag.get();
    }
}
