package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

public class AllNonPrimeSearchTest {

    static class PrimeSearchableProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                Arguments.of(new SeqNonPrimeSearch()),
                Arguments.of(new StreamNonPrimeSearch()),
                Arguments.of(new ParNonPrimeSearch(1)),
                Arguments.of(new ParNonPrimeSearch(2)),
                Arguments.of(new ParNonPrimeSearch(3)),
                Arguments.of(new ParNonPrimeSearch(4)));
        }

        @ParameterizedTest()
        @ArgumentsSource(PrimeSearchableProvider.class)
        void allPrimesTest1(PrimeSearchable primeSearchable) throws InterruptedException {
            assertEquals(primeSearchable.containNotPrime( new int[] {2, 3, 5, 7}), false);
        }

        @ParameterizedTest()
        @ArgumentsSource(PrimeSearchableProvider.class)
        void allPrimesTest2(PrimeSearchable primeSearchable) throws InterruptedException {
            assertEquals(primeSearchable.containNotPrime( new int[] {2, 3, 5, 7, 11, 13}), false);
        }

        @ParameterizedTest()
        @ArgumentsSource(PrimeSearchableProvider.class)
        void notAllPrimesTest1(PrimeSearchable primeSearchable) throws InterruptedException {
            assertEquals(primeSearchable.containNotPrime( new int[] {2, 3, 5, 7, 100}), true);
        }

        @ParameterizedTest()
        @ArgumentsSource(PrimeSearchableProvider.class)
        void notAllPrimesTest2(PrimeSearchable primeSearchable) throws InterruptedException {
            assertEquals(primeSearchable.containNotPrime( new int[] {2, 3, 5, 7, 11, 13, 100}), true);
        }
    }
}
