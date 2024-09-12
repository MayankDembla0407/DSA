package searching.leetcode;


/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 */
public class L02 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3};

        System.out.println(getIndex(arr, 2)) ;

    }

    public static int getIndex(int[] num, int key) {

        int low = 0 ;
        int high = num.length - 1 ;

        while (high >= low){

            int mid = (high + low) / 2 ;

            if(num[mid] == key )
                return mid ;

            if(num[low] <= num[mid]) { // left part is sorted
                if(num[low] <= key && key <= num[mid]){
                    high = mid-1;
                }else{
                    low = mid + 1 ;
                }
            }

            if(num[mid] <= num[high]){ // right part is sorted
                if(num[mid] <= key && key <= num[high]){
                    low = mid + 1 ;
                }else{
                    high = mid - 1 ;
                }
            }
        }

        return  -1 ;
    }


}
