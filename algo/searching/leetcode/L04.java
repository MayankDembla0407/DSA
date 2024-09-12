package searching.leetcode;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */
public class L04 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6} ;

        System.out.println(findIndex(arr, 7)) ;
    }

    public static int findIndex(int[] arr, int key){
        int low = 0 ;
        int high = arr.length - 1 ;

        while (high >= low){
            int mid = (low+high)/2 ;

            if(arr[mid] == key){
                return mid ;
            }

            if(arr[mid] > key){
                high = mid -1 ;
            }else{
                low = mid + 1 ;
            }

        }
      return  high + 1 ;
    }
}
