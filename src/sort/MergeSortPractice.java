package sort;

public class MergeSortPractice {
    
    @SuppressWarnings("rawtypes")
    public static Comparable[] mergeSort (Comparable[] list) {
        
        if (list.length <= 1) {
            return list;
        }
        
        // Split original array into two sub-arrays
        Comparable[] first = new Comparable[list.length/2];
        Comparable[] second = new Comparable[list.length - list.length/2];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
        
        // Recursively call mergeSort on sub-arrays
        mergeSort(first);
        mergeSort(second);
        
        // Sort and merge sub-arrays, overwriting original list
        merge(first, second, list);
        
        return list;
    }
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void merge (Comparable[] first, Comparable[] second, Comparable[] orig) {
        int iFirst = 0, iSecond = 0, iOrig = 0;
        
        // Perform first copy run
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].compareTo(second[iSecond]) <= 0) {
                orig[iOrig] = first[iFirst];
                iFirst++;
            } else {
                orig[iOrig] = second[iSecond];
                iSecond++;
            }
            iOrig++;
        }
        
        // Copy over remnants of either first or second
        System.arraycopy(first, iFirst, orig, iOrig, first.length - iFirst);
        System.arraycopy(second, iSecond, orig, iOrig, second.length - iSecond);
    }
    
}
