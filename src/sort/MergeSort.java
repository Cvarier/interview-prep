package sort;

// Ascending order
public class MergeSort {

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Comparable[] mergeSort(Comparable[] list) {
        if (list.length <= 1) {
            return list;
        }

        // Split original array into two subarrays
        Comparable[] first = new Comparable[list.length/2];
        Comparable[] second = new Comparable[list.length
                        - list.length / 2];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        // Sort each half recursively
        mergeSort(first);
        mergeSort(second);

        // Merge first and second arrays together, overwriting original array
        merge(first, second, list);

        return list;

    }

    @SuppressWarnings("unchecked")
    private static <T> void merge(Comparable<T>[] first, Comparable<T>[] second,
                    Comparable<T>[] list) {
        int i = 0, j = 0, k = 0;
        
        while (i < first.length && j < second.length) {
            if (first[i].compareTo((T) second[j]) < 0) {
                list[k] = first[i];
                i++;
            } else {
                list[k] = second[j];
                j++;
            }
            k++;
        }

        // Merge remainders of first or second
        System.arraycopy(first, i, list, k, first.length-i);
        System.arraycopy(second, j, list, k, second.length-j);
    }
    
    public static void main (String[] args) {
        Double[] arr = {0.01, -0.003, -2.0, 4.0, 99.0, 96.0, 36.0, -36.0, -99.0, -121.0, 399.0};
        mergeSort(arr);
        for (double i : arr) {
            System.out.print(i + " ");
        }
    }
}
