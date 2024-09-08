package ru.nsu.dubrovin;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class HeapsortTest {

    // Первая группа тестов для проверки работоспособности.

    @Test
     void test0EmptyArray() {
        int[] arr = new int[]{};
        Heapsort.heapsort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void teat1OneElement() {
        int[] arr = new int[]{0};
        Heapsort.heapsort(arr);
        assertArrayEquals(new int[]{0}, arr);
    }

    @Test
    void test2SameElements() {
        int[] arr = new int[]{0, 0, 0, 0, 0};
        Heapsort.heapsort(arr);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, arr);
    }

    @Test
    void test3SortedArray() {
        int[] arr = new int[]{1, 1, 2, 3, 7, 7, 9, 19};
        Heapsort.heapsort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 7, 7, 9, 19}, arr);
    }

    @Test
    void test4ReversedSortedArray() {
        int[] arr = new int[]{11, 7, 6, 6, 5, 4, 1, 1, 0};
        Heapsort.heapsort(arr);
        assertArrayEquals(new int[]{0, 1, 1, 4, 5, 6, 6, 7, 11}, arr);
    }

    @Test
    void test5AlreadyHeap() {
        int[] arr = new int[]{9, 8, 7, 4, 5, 6, 3, 2, 1};
        Heapsort.heapsort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }

    @Test
    void test6Random() {
        int[] arr = new int[]{0, 7, 4, 19, 8, 4, 19, 7, 7, 11, 3, 2, 0};
        Heapsort.heapsort(arr);
        assertArrayEquals(new int[]{0, 0, 2, 3, 4, 4, 7, 7, 7, 8, 11, 19, 19}, arr);
    }

    @Test
    void test7Random() {
        int[] arr = new int[]{6456, 7856745, 7856, 764534, 13, 9778078, 345, 5436565, 782434};
        Heapsort.heapsort(arr);
        assertArrayEquals(new int[]{13, 345, 6456, 7856, 764534, 782434, 5436565, 7856745,
            9778078}, arr);
    }

    @Test
    void test8IntBorders() {
        //https://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html#jls-4.2
        int[] arr = new int[]{2147483647, 2147483647, 2147483646, 0, -2147483647, -2147483648,
            -2147483648};
        Heapsort.heapsort(arr);
        assertArrayEquals(new int[]{-2147483648, -2147483648, -2147483647, 0, 2147483646,
            2147483647, 2147483647}, arr);
    }

    // Вторая группа тестов для проверки времени работы программы
    // Не используются ассерты (мы ожидаем увидеть тенденцию, а не числа)

    @Test
    void timeTest() {
        System.out.println("Тесты, показывающие зависимость кол-ва операций от размера массива");

        int[] arr1 = new int[100];
        fill(arr1);
        System.out.println("Кол-во операций для " + arr1.length + " элем: " +
            Heapsort.heapsort(arr1));

        int[] arr2 = new int[200];
        fill(arr2);
        System.out.println("Кол-во операций для " + arr2.length + " элем: " +
            Heapsort.heapsort(arr2));

        int[] arr3 = new int[300];
        fill(arr3);
        System.out.println("Кол-во операций для " + arr3.length + " элем: " +
            Heapsort.heapsort(arr3));

        int[] arr4 = new int[400];
        fill(arr4);
        System.out.println("Кол-во операций для " + arr4.length + " элем: " +
            Heapsort.heapsort(arr4));

        int[] arr5 = new int[500];
        fill(arr5);
        System.out.println("Кол-во операций для " + arr5.length + " элем: " +
            Heapsort.heapsort(arr5));
        System.out.println("График - https://www.desmos.com/calculator/3ujfopftsu?lang=ru");
    }

    void fill(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++){
            arr[i] = i;
        }
    }
}