package ru.nsu.dubrovin;

/**
 * Основной класс, содержит публичный метод сортировки кучей.
 */
public class Heapsort {

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
    private static int heapify(int[] arr, int n, int i, int depth) {
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
            depth = heapify(arr, n, largest, depth);
        }

        return depth + 1;
    }

    /**
     * Свапает два элемента массива (меняет местами).
     *
     * @param arr сам массив
     *
     * @param fstInd индекс первого элемента
     *
     * @param sndInd индекс второго элемента
     */
    private static void swap(int[] arr, int fstInd, int sndInd) {
        int tmp = arr[fstInd];
        arr[fstInd] = arr[sndInd];
        arr[sndInd] = tmp;
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
            iterations += heapify(arr, len, i, 0);
        }

        for (int i = len - 1; i >= 0; i--) {
            swap(arr, 0, i);
            iterations += heapify(arr, i, 0, 0);
        }

        return iterations;
    }
}