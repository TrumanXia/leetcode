package leetcode.sort;

import java.util.Random;

public class SortHelper {
    public static Comparable[] copyOfArray(Comparable[] source) {
        int len = source.length;
        Comparable[] target = new Comparable[len];

        for(int i = 0; i < len; i++) {
            target[i] = source[i];
        }
        return target;
    }

//    include low, exclude high;
    public static Comparable[] copyArrayOfRange(Comparable[] source, int low, int high) {
        int len = source.length;
        Comparable[] target = new Comparable[high - low];

        for(int i = 0; i < high - low; i++) {
            target[i] = source[i + low];
        }
        return target;
    }

    public static boolean less (Comparable a, Comparable b) {
        if (a.compareTo(b) < 0) {
            return true;
        }
        return false;
    }

    public static Comparable[] generateRandomArray() {
        int size = new Random().nextInt(20);

        Comparable[] comparable = new Comparable[size + 1];
        for (int i = 0; i < size + 1; i++) {
            comparable[i] = new Random().nextInt(i + 1);
        }
        return comparable;
    }

    public static void printArr(Comparable[] arr) {
        for (Comparable comparable : arr) {
            System.out.print(comparable.toString() + "\t");
        }
    }

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printNewLine() {
        System.out.println();
    }
}
