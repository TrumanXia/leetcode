package leetcode.sort;

public class Sort {

    public static void sort(Comparable[] arr) {
//        include
        doMergeAct(arr, 0, arr.length - 1);
    }

    public static void doMergeAct(Comparable[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
//        这边不能是减法，而应该是加法，算中间值。
        int mid = (high + low) / 2;
        doMergeAct(arr, low, mid);
        doMergeAct(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

//    包括high
    public static void merge (Comparable[] arr, int low, int mid, int high){
        Comparable[] aux = SortHelper.copyArrayOfRange(arr, low, high + 1);
        System.out.println(low + " "+ high);
        SortHelper.printArr(aux);
        SortHelper.printNewLine();
        int i = low, j = mid + 1;
//不一定从 0 开始
//        for (int k = 0; k < high; k ++){
        for (int k = low; k < high; k ++){
            if (SortHelper.less(aux[j - low], aux[i - low])) {
                arr[k] = aux[j - low];
                j++;
            } else if (j >= high) {
                arr[k] = aux[i - low];
                i++;
            } else if (i >= mid) {
                arr[k] = aux[j - low];
                j++;
            } else {
                arr[k] = aux[i -low];
                i++;
            }
        }

    }

    public static void main(String[] args) {
        Comparable[] comparables = SortHelper.generateRandomArray();
        SortHelper.printArr(comparables);
        SortHelper.printNewLine();
        sort(comparables);

        SortHelper.printArr(comparables);
    }
}
