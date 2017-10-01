package sort;

public class QuickSortPractice {
    
    @SuppressWarnings("rawtypes")
    public static void quickSort (Comparable[] a) {
        quickSortPartial(a, 0, a.length-1);
    }
    
    @SuppressWarnings("rawtypes")
    public static void quickSortPartial (Comparable[] a, int lo, int hi) {
        if (a.length <= 1 || (hi - lo) <= 0) {
            return;
        }
        // Partition array and obtain the final index of the partitioner after rearranging
        int m = partition(a, lo, hi);
        // Recursively sort left and right partitions
        quickSortPartial(a, lo, m - 1);
        quickSortPartial(a, m + 1, hi);
    }
    
    /* Take partitioner as first element of array, then rearrange array elements
     * such that all elements less than it are to the left of it and all elements
     * greater than it are to the right of it.
     */
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
        Boolean[] arr = {false, false, false, true, false};
        quickSort(arr);
        for (boolean e : arr) {
            System.out.print(e + " ");
        }
    }

}
