package searching.leetcode;

import java.util.Arrays;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 */
public class L10 {

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6};
        System.out.println("The Peak element is: " + Arrays.toString(twoSum(nums, 8)));  // Output: 0
    }

    public static int[] twoSum(int[] numbers, int target) {

        int l = 0 ;
        int r = numbers.length - 1 ;

        while(r >= l){

            int sum = numbers[l] + numbers[r] ;

            if(sum == target){
                return new int[] {l+1,r+1} ;
            }

            if(sum > target){
                r-- ;
            }else{
                l++;
            }

        }
        return new int[]{0,0} ;
    }
}
