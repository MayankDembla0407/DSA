package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ActivityProblem {

    public static void main(String[] args) {
        int[] startTime = {1, 3, 0, 5, 8, 5} ;
        int[] endTime = {2, 4, 6, 7, 9, 9} ;

        selectActivities(startTime, endTime) ;

    }


    public static void selectActivities(int[] startTime , int[] endTime){

        TreeMap<Integer, Integer> map = new TreeMap<>() ; // keep the key in sorted order

        for (int i = 0 ; i < startTime.length ; i++) {
            map.put(endTime[i] , startTime[i]) ;    // O(log n) - self balancing binary search tree
        }

        int lastEndTime = -1 ;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){  // O(n)
            int currentEndTime = entry.getKey() ;
            int currentStartTime = entry.getValue() ;

            if(currentStartTime >= lastEndTime){
                System.out.println("Activity Selected : start " + currentStartTime + " end : " + currentEndTime );
                lastEndTime = currentEndTime ;
            }
        }
    }
}


// Total Time Complexity - O(nlogn) - to insert elements to treemap
// O(n) to iterate

// ----- Overall O(nlogn)

// ---- Space Complexity - O(n) TreeMap