package searching.leetcode;


/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 */
public class L11 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println("The Peak element is: " + findSub(nums, 7));  // Output: 0
    }

    public static int findSub(int[] nums, int target){

        int start = 0 ;
        int minSum = 0 ;
        int minLen = Integer.MAX_VALUE; ;

        for(int end = 0 ; end < nums.length; end ++){
            minSum = minSum + nums[end] ;

            while(minSum >= target){
                minLen = Math.min((end - start) + 1, minLen) ;
                minSum = minSum - nums[start] ;
                start++ ;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen ;
    }



}
