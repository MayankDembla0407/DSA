package searching.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 */
public class L13 {

    public static void main(String[] args) {

       int[] arr = new int[]{0,1,2,3,5} ;
        System.out.println(findMissing(arr));
    }

    public static int findMissing(int[] arr){
        int length = arr.length - 1 ;
        int expecedSum = (length)*(length+1) / 2 ; // formula for (0,n) -> n(n+1)/2

        // Calculate the actual sum of elements in the array using Streams
        int actualSum = Arrays.stream(arr).sum();

        if(expecedSum == actualSum)
            return  arr.length  ;
        else
            return (expecedSum - actualSum) ;
    }


}
