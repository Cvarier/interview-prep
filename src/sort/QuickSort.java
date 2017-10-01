package sort;

public class QuickSort {
    
    // lo => lowest index; hi => highest index
    @SuppressWarnings("rawtypes")
    public static void quickSort (Comparable[] a, int lo, int hi) {
        if (a.length <= 1 || (hi - lo) <= 1) {
            return;
        }
        // partition array and store pivot in m
        int m = partition(a, lo, hi);
        // quicksort left partition
        quickSort(a, lo, m - 1);
        // quicksort right partition
        quickSort(a, m + 1, hi);
    }
    
    // partitioner is first element
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static int partition (Comparable[] a, int lo, int hi) {
        int m = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (a[i].compareTo(a[lo]) < 0) {
                swap(a, i, ++m);
            }
        }
        swap(a, lo, m);
        return m;
    }
 
    @SuppressWarnings("rawtypes")
    private static void swap (Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void main (String[] args) {
        Double[] arr = {0.01, -0.003, 2.1, -2.0, 4.0, 99.0, 96.0, -2.1, 0.02, 36.0, -36.0, -99.0, -121.0, 399.0};
        quickSort(arr, 0, arr.length-1);
        for (double i : arr) {
            System.out.print(i + " ");
        }
    }

}
