package searching.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class L03 {

    public static void main(String[] args) {
        int[] arr = new int[] {5,7,7,8,8,10} ;
        int key = 8 ;
        int[] result = new int[]{findFirstOccurence(arr,key), findLastOccurance(arr,key)} ;
        System.out.println(Arrays.toString(result));

    }

    // first Occurrence
    public static int findFirstOccurence(int[] arr, int key){
       return IntStream.range(0, arr.length)
                .filter(i -> arr[i] == key)
                .findFirst()
                .orElse(-1) ;
    }

    public int findleftOccurance(int[] nums, int target){
        int left = 0 ;
        int right = nums.length -1 ;
        int leftIndex = -1 ;
        while(left <= right ){
            int mid = (left + right) / 2 ;

            if(nums[mid] == target){
                leftIndex= mid ;
                right = mid -1 ;
            }else{
                if(target < nums[mid])
                    right = mid - 1 ;
                else
                    left = mid + 1 ;
            }
        }
        return leftIndex ;
    }

    public static int findLastOccurance(int[] arr, int key){

        int left = 0 ;
        int right = arr.length -1 ;
        int rightposition = -1 ;

        while (right >= left){
            int mid = (right + left) /2 ;

            if(arr[mid] == key){
                rightposition = mid ;
                left = mid + 1 ;
            }

            if(key < arr[mid])
                right = mid -1 ;
            else
                left = mid + 1 ;

        }
        return  rightposition ;
    }


}
