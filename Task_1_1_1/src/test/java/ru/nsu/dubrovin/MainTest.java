package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MainTest {

    // Первая группа тестов для проверки работоспособности.

    @Test
    void test0EmptyArray() {
        int[] arr = new int[]{};
        Main.heapsort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void test1SameElements() {
        int[] arr = new int[]{0, 0, 0, 0, 0};
        Main.heapsort(arr);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, arr);
    }

    @Test
    void test2SortedArray() {
        int[] arr = new int[]{1, 1, 2, 3, 7, 7, 9, 19};
        Main.heapsort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 7, 7, 9, 19}, arr);
    }

    @Test
    void test3ReversedSortedArray() {
        int[] arr = new int[]{11, 7, 6, 6, 5, 4, 1, 1, 0};
        Main.heapsort(arr);
        assertArrayEquals(new int[]{0, 1, 1, 4, 5, 6, 6, 7, 11}, arr);
    }

    @Test
    void test4AlreadyHeap() {
        int[] arr = new int[]{9, 8, 7, 4, 5, 6, 3, 2, 1};
        Main.heapsort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }

    @Test
    void test5Random() {
        int[] arr = new int[]{0, 7, 4, 19, 8, 4, 19, 7, 7, 11, 3, 2, 0};
        Main.heapsort(arr);
        assertArrayEquals(new int[]{0, 0, 2, 3, 4, 4, 7, 7, 7, 8, 11, 19, 19}, arr);
    }

    @Test
    void test6Random() {
        int[] arr = new int[]{6456, 7856745, 7856, 764534, 13, 9778078, 345, 5436565, 782434};
        Main.heapsort(arr);
        assertArrayEquals(new int[]{13, 345, 6456, 7856, 764534, 782434, 5436565, 7856745,
            9778078}, arr);
    }

    @Test
    void test7IntBorders() {
        //https://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html#jls-4.2
        int[] arr = new int[]{2147483647, 2147483647, 2147483646, 0, -2147483647, -2147483648,
            -2147483648};
        Main.heapsort(arr);
        assertArrayEquals(new int[]{-2147483648, -2147483648, -2147483647, 0, 2147483646,
            2147483647, 2147483647}, arr);
    }
}