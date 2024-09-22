package searching.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L17 {

    public static void main(String[] args) {
        int[] arr = new  int[]{10,9,2,5,3,7,101,18} ;

        System.out.println(findSubString(arr));

    }

    // tryint to implement loose
    public static int findSubString(int[] arr){

        List<Integer> list = new ArrayList<Integer>() ;

        for(int num : arr){

            int pos = Collections.binarySearch(list, num ) ;

            if(pos < 0 ){
                pos = -(pos + 1);  // Find the insertion point
            }

            if (pos == list.size()) {
                list.add(num);  // Append to the end if it's the largest
            } else {
                list.set(pos, num);  // Replace the element at the insertion point
            }

        }
        return  list.size() ;
    }

}
