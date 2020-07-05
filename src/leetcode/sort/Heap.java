package leetcode.sort;
//堆排序时间复杂度 也是 nlogn
public class Heap<K extends Comparable<K>> {

//    private K[] pq;
//
//    public Heap(int size) {
//        pq = (K[]) new Comparable[size];
//    }
//- 4 3 6 3
//    怎样将无序数组堆化
    public static void sink(Comparable[] arr, int k, int n) {
        while (2 * k < n) {
            int j = 2 * k;
            if (j < n && SortHelper.less(arr[j - 1], arr[j])) {
                j++;
            }
            System.out.println(arr[j] + " \t" + arr[k]);
            if (!SortHelper.less(arr[k - 1], arr[j - 1])) {
                break;
            }
            SortHelper.swap(arr, k, j);
//            更新k;
            k = j;
        }
    }

    public static void sort(Comparable[] arr) {
        int N = arr.length;

        for (int k = N/2; k >= 1; k--) {
            sink(arr, k, N);
        }

    }

    public static void main(String[] args) {
        Comparable[] comparables = SortHelper.generateRandomArray();
//        comparables[0] = 0;
        SortHelper.printArr(comparables);
        SortHelper.printNewLine();
        sort(comparables);
        SortHelper.printArr(comparables);

//        new Heap<Integer>(5)
    }
}
