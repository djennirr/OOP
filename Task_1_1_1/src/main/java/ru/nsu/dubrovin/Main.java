package ru.nsu.dubrovin;

/**
 * Основной класс.
 */
public class Main {

    /**
     * Главный метод (не используется).
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
    }

    /**
     * Хипизация (превращение в двочинуб кучу) участка массива.
     *
     * @param arr сам массив
     *
     * @param i индекс корня
     *
     * @param n размер кучи
     *
     * @param depth используется для подсчета глубины рекурсии для док-ва времени работы
     *
     * @return глубина рекурсии
     */
    private static int heapify(int[] arr, int n, int i, int[] depth) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            depth[0] += 1;
            heapify(arr, n, largest, depth);
        }

        return depth[0];
    }

    /**
     * Свапает два элемента массива (меняет местами).
     *
     * @param arr сам массив
     *
     * @param fstind индекс первого элемента
     *
     * @param sndind индекс второго элемента
     */
    private static void swap(int[] arr, int fstind, int sndind) {
        int tmp = arr[fstind];
        arr[fstind] = arr[sndind];
        arr[sndind] = tmp;
    }

    /**
     * Сортировка двоичной кучей.
     *
     * @param arr двоичная куча (хранится как одномерный массив)
     *
     * @return количество итераций
     */
    public static int heapsort(int[] arr) {
        int len = arr.length;
        int iterations = 0;
        for (int i = len / 2 - 1; i >= 0; i--) {
            iterations += heapify(arr, len, i, new int[]{1});
        }

        for (int i = len - 1; i >= 0; i--) {
            swap(arr, 0, i);
            iterations += heapify(arr, i, 0, new int[]{1});
        }

        return iterations;
    }
}