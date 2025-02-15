package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

/**
 * Tests class.
 */
public class AllNonPrimeSearchTest {

    /**
     * Class to provide tests with different primesearchable classes.
     */
    static class PrimeSearchableProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext)
                throws Exception {
            return Stream.of(
                    Arguments.of(new SeqNonPrimeSearch()),
                    Arguments.of(new StreamNonPrimeSearch()),
                    Arguments.of(new ParNonPrimeSearch(1)),
                    Arguments.of(new ParNonPrimeSearch(2)),
                    Arguments.of(new ParNonPrimeSearch(3)),
                    Arguments.of(new ParNonPrimeSearch(4)));
        }
    }

    boolean speedTest(PrimeSearchable primeSearchable, int[] arr) throws InterruptedException {
        boolean flag;
        long startTime;
        long workTime;
        startTime = System.currentTimeMillis();
        flag = primeSearchable.containNotPrime(arr);
        workTime = System.currentTimeMillis() - startTime;
        System.out.println(primeSearchable.getClass().getSimpleName() + " finished in " + workTime
            + " millis.");
        return flag;
    }

    //Only prime numbers.

    @ParameterizedTest()
    @ArgumentsSource(PrimeSearchableProvider.class)
    void allPrimesTest1(PrimeSearchable primeSearchable) throws InterruptedException {
        assertEquals(primeSearchable.containNotPrime(new int[]{2, 3, 5, 7}), false);
    }

    @ParameterizedTest()
    @ArgumentsSource(PrimeSearchableProvider.class)
    void allPrimesTest2(PrimeSearchable primeSearchable) throws InterruptedException {
        assertEquals(primeSearchable.containNotPrime(new int[]{2, 3, 5, 7, 11, 13}), false);
    }

    @ParameterizedTest()
    @ArgumentsSource(PrimeSearchableProvider.class)
    void allPrimesTest3(PrimeSearchable primeSearchable) throws InterruptedException {
        int[] somePrimeNumbers = new int[] {10007, 10009, 10037, 10039, 10061, 10067, 10069, 10079,
            10091, 10093, 10099, 10103, 10111, 10133, 10139, 10141, 10151, 10159, 10163, 10169,
            10177, 10181, 10193, 10211, 10223, 10243, 10247, 10253, 10259, 10267, 10271, 10273,
            10289, 10301, 10303, 10313, 10321, 10331, 10333, 10337, 10343, 10357, 10369, 10391,
            10399, 10427, 10429, 10433, 10453, 10457, 10459, 10463, 10477, 10487, 10499, 10501,
            10513, 10529, 10531, 10559, 10567, 10589, 10597, 10601, 10607, 10613, 10627, 10631,
            10639, 10651, 10657, 10663, 10667, 10687, 10691, 10709, 10711, 10723, 10729, 10733,
            10739, 10753, 10771, 10781, 10789, 10799, 10831, 10837, 10847, 10853, 10859, 10861,
            10867, 10883, 10889, 10891, 10903, 10909, 10937, 10939};
        assertEquals(primeSearchable.containNotPrime(somePrimeNumbers), false);
    }

    //Not only prime numbers;

    @ParameterizedTest()
    @ArgumentsSource(PrimeSearchableProvider.class)
    void notAllPrimesTest1(PrimeSearchable primeSearchable) throws InterruptedException {
        assertEquals(primeSearchable.containNotPrime(new int[]{2, 3, 5, 7, 100}), true);
    }

    @ParameterizedTest()
    @ArgumentsSource(PrimeSearchableProvider.class)
    void notAllPrimesTest2(PrimeSearchable primeSearchable) throws InterruptedException {
        assertEquals(primeSearchable.containNotPrime(new int[]{2, 3, 5, 7, 11, 13, 100}),
                true);
    }

    @ParameterizedTest()
    @ArgumentsSource(PrimeSearchableProvider.class)
    void notAllPrimesTest3(PrimeSearchable primeSearchable) throws InterruptedException {
        int[] somePrimeNumbers = new int[] {10007, 10009, 10037, 10039, 10061, 10067, 10069, 10079,
            10091, 10093, 10099, 10103, 10111, 10133, 10139, 10141, 10151, 10159, 10163, 10169,
            10177, 10181, 10193, 10211, 10223, 10243, 10247, 10253, 10259, 10267, 10271, 10273,
            10289, 10301, 10303, 10313, 10321, 10331, 10333, 10337, 10343, 10357, 10369, 10391,
            10399, 10427, 10429, 10433, 10453, 10457, 10459, 10463, 10477, 10487, 10499, 10501,
            10513, 10529, 10531, 10559, 10567, 10589, 10597, 10601, 10607, 10613, 10627, 10631,
            10639, 10651, 10657, 10663, 10667, 10687, 10691, 10709, 10711, 10723, 10729, 10733,
            10739, 10753, 10771, 10781, 10789, 10799, 10831, 10837, 10847, 10853, 10859, 10861,
            10867, 10883, 10889, 10891, 10903, 10909, 10937, 10939, 10939 * 10939};
        assertEquals(primeSearchable.containNotPrime(somePrimeNumbers), true);
    }

    //Speed tests.

    @ParameterizedTest()
    @ArgumentsSource(PrimeSearchableProvider.class)
    void notAllPrimesSpeedTest(PrimeSearchable primeSearchable) throws InterruptedException {
        int[] somePrimeNumbers = new int[] {10007, 10009, 10037, 10039, 10061, 10067, 10069, 10079,
            10091, 10093, 10099, 10103, 10111, 10133, 10139, 10141, 10151, 10159, 10163, 10169,
            10177, 10181, 10193, 10211, 10223, 10243, 10247, 10253, 10259, 10267, 10271, 10273,
            10289, 10301, 10303, 10313, 10321, 10331, 10333, 10337, 10343, 10357, 10369, 10391,
            10399, 10427, 10429, 10433, 10453, 10457, 10459, 10463, 10477, 10487, 10499, 10501,
            10513, 10529, 10531, 10559, 10567, 10589, 10597, 10601, 10607, 10613, 10627, 10631,
            10639, 10651, 10657, 10663, 10667, 10687, 10691, 10709, 10711, 10723, 10729, 10733,
            10739, 10753, 10771, 10781, 10789, 10799, 10831, 10837, 10847, 10853, 10859, 10861,
            10867, 10883, 10889, 10891, 10903, 10909, 10937, 10939};
        assertEquals(speedTest(primeSearchable, somePrimeNumbers), false);
    }
}
