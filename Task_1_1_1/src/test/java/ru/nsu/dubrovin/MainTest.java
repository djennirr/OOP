package ru.nsu.dubrovin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void Test_1_same_elements() {
        int[] arr = {0, 0, 0, 0, 0};
        Main.heapsort(arr);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, arr);
    }

    @Test
    void Test_2_sorted_array() {
        int[] arr = {1, 1, 2, 3, 7, 7, 9, 19};
        Main.heapsort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 7, 7, 9, 19}, arr);
    }

    @Test
    void Test_3_reversed_sorted_array() {
        int[] arr = {11, 7, 6, 6, 5, 4, 1, 1, 0};
        Main.heapsort(arr);
        assertArrayEquals(new int[]{0, 1, 1, 4, 5, 6, 6, 7, 11}, arr);
    }

    @Test
    void Test_4_already_heap() {
        int[] arr = {9, 8, 7, 4, 5, 6, 3, 2, 1};
        Main.heapsort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }

    @Test
    void Test_5_random() {
        int[] arr = {0, 7, 4, 19, 8, 4, 19, 7, 7, 11, 3, 2, 0};
        Main.heapsort(arr);
        assertArrayEquals(new int[]{0, 0, 2, 3, 4, 4, 7, 7, 7, 8, 11, 19, 19}, arr);
    }

    @Test
    void Test_6_random() {
        int[] arr = {6456, 7856745, 7856, 764534, 13, 9778078, 345, 5436565, 782434};
        Main.heapsort(arr);
        assertArrayEquals(new int[]{13, 345, 6456, 7856, 764534, 782434, 5436565, 7856745, 9778078}, arr);
    }

    @Test
    void Test_7_int_borders() {
        int[] arr = {2147483647, 2147483647, 2147483646, 0, -2147483647, -2147483648, -2147483648};
        Main.heapsort(arr);
        assertArrayEquals(new int[]{-2147483648, -2147483648, -2147483647, 0, 2147483646, 2147483647, 2147483647}, arr);
    }
}