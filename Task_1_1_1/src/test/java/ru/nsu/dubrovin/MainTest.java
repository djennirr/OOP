package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void HeapsortTest(){
        int[] tst1_same_elem = {0, 0, 0, 0, 0};
        Main.heapsort(tst1_same_elem);
        assertArrayEquals(new int[] {0, 0, 0, 0, 0}, tst1_same_elem);

        int[] tst2_sorted = {1, 1, 2, 3, 7, 7, 9, 19};
        Main.heapsort(tst2_sorted);
        assertArrayEquals(new int[] {1, 1, 2, 3, 7, 7, 9, 19}, tst2_sorted);

        int[] tst3_reversed = {11, 7, 6, 6, 5, 4, 1, 1, 0};
        Main.heapsort(tst3_reversed);
        assertArrayEquals(new int[] {0, 1, 1, 4, 5, 6, 6, 7, 11}, tst3_reversed);

        int[] tst4_already_heap = {9, 8, 7, 4, 5, 6, 3, 2, 1};
        Main.heapsort(tst4_already_heap);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, tst4_already_heap);

        int[] tst5_random = {0, 7, 4, 19, 8, 4, 19, 7, 7, 11, 3, 2, 0};
        Main.heapsort(tst5_random);
        assertArrayEquals(new int[] {0, 0, 2, 3, 4, 4, 7, 7, 7, 8, 11, 19, 19}, tst5_random);

        int[] tst6_random = {6456, 7856745, 7856, 764534, 13, 9778078, 345, 5436565, 782434};
        Main.heapsort(tst6_random);
        assertArrayEquals(new int[] {13, 345, 6456, 7856, 764534, 782434, 5436565, 7856745, 9778078}, tst6_random);

        int[] tst7_int_borders = {2147483647, 2147483647, 2147483646, 0, -2147483647, -2147483648, -2147483648};
        Main.heapsort(tst7_int_borders);
        assertArrayEquals(new int[] {-2147483648, -2147483648, -2147483647, 0, 2147483646, 2147483647, 2147483647}, tst7_int_borders);
    }
}