package ctci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import sort.MergeSort;

// non-rotatable
public class BoxStacker2D {
    
    public static void main (String args[]) {
       // width, length
       Integer[][] boxes = {{1,2}, {2,2}, {1,1}, {2,3}, {9,1}, {1,9}, {2,5}, {7,7}, {4,5}, {1,10}, {5,4}};
       // sort boxes array by width first
       Arrays.sort(boxes, new Comparator<Integer[]>() {
           public int compare(Integer[] int1, Integer[] int2) {
               Integer numOfKeys1 = int1[0];
               Integer numOfKeys2 = int2[0];
               return numOfKeys1.compareTo(numOfKeys2);
           }
       });
       
       // get sublists where width is the same
       int k = 0, m = 0;
       int curNum = boxes[k][0];
       ArrayList<ArrayList<ArrayList<Integer>>> subLists = new ArrayList<ArrayList<ArrayList<Integer>>>();
       subLists.add(new ArrayList<>());
       while (k < boxes.length){
           if (boxes[k][0] != curNum) {
               m++;
               curNum = boxes[k][0];
               subLists.add(new ArrayList<>());
           }
           subLists.get(m).add(new ArrayList<Integer>(Arrays.asList(boxes[k])));
           subLists.set(m, subLists.get(m));
           k++;
       }
       
       // sort individual sublists where width is same by length
       ArrayList<Integer[][]> boxesSorted = new ArrayList<Integer[][]>();
       for (ArrayList<ArrayList<Integer>> e : subLists) {
           Integer[][] eAsArray = new Integer[e.size()][2];
           for (int n = 0; n < e.size(); n++) {
               eAsArray[n][0] = e.get(n).get(0);
               eAsArray[n][1] = e.get(n).get(1);
           }
           
           Arrays.sort(eAsArray, new Comparator<Integer[]>() {
               public int compare(Integer[] int1, Integer[] int2) {
                   Integer numOfKeys1 = int1[1];
                   Integer numOfKeys2 = int2[1];
                   return numOfKeys1.compareTo(numOfKeys2);
               }
           });
           boxesSorted.add(eAsArray);
       }
       
       // concatenate sorted sublists
       int lastSize = 0;
       for (Integer[][] subList : boxesSorted) {
           for (int i = 0; i < subList.length; i++) {
               boxes[i + lastSize] = subList[i];
           }
           lastSize += subList.length;
       }
       
       for (Integer[] pair : boxes) {
           System.out.println(pair[0] + " " + pair[1]);
       }
       
       int[] maxBoxes = new int[boxes.length];
       
       for (int i = 0; i < boxes.length; i++) {
           int curMax = 1;
           for (int j = 0; j < i; j++) {
               if (boxes[j][0] <= boxes[i][0] && boxes[j][1] <= boxes[i][1] && maxBoxes[j] + 1 > curMax) {
                   curMax = maxBoxes[j] + 1;
               }
           }
           maxBoxes[i] = curMax;
       }
       
       Arrays.sort(maxBoxes);
       System.out.println("\n" + maxBoxes[maxBoxes.length-1]);
    }
    
}
