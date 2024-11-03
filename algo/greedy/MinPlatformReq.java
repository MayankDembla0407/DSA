package greedy;

import java.util.Arrays;

public class MinPlatformReq {

    public static void main(String[] args) {
        String[] arrival = {"9:00", "9:40", "9:50", "11:00", "15:00", "18:00"};
        String[] dep = {"9:10", "12:00", "11:20", "11:30", "19:00", "20:00"} ;

        // Normalize
        int[] arr = new int[arrival.length] ;
        for(int i = 0 ; i < arrival.length ; i++){
            arr[i] = Integer.parseInt(arrival[i].replace(":","")) ;
        }

        int[] dept = new int[dep.length] ;
        for(int i = 0 ; i < dep.length ; i++){
            dept[i] = Integer.parseInt(dep[i].replace(":","")) ;
        }

        System.out.println(findMaxPlatform(arr, dept));

    }

    private static int findMaxPlatform(int[] arr, int[] dept){

        Arrays.sort(arr);
        Arrays.sort(dept);

        int arrPointer = 1 ;
        int deptPointer = 0 ;
        int maxPlatform = 1 ;
        int currentReq = 1 ;

        while (arr.length > arrPointer && dept.length > deptPointer){

            if(dept[deptPointer] >= arr[arrPointer] ){
                currentReq++ ;
                arrPointer++;
            } else{
                currentReq-- ;
                deptPointer++;
            }

            maxPlatform = Math.max(maxPlatform, currentReq);
        }
      return  maxPlatform ;
    }





}
