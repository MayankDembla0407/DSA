package searching.leetcode;

import java.util.Arrays;

public class L09 {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println("The Peak element is: " + findPeakElement(nums));  // Output: 0
    }

    public static int findPeakElement(int[] nums) {

        int left = 0 ;
        int right = nums.length - 1 ;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the middle element is greater than the next element, the peak is in the left half
            if (mid < nums.length - 1  && nums[mid] > nums[mid + 1]) {
                right = mid;  // Move towards the left half
            } else {
                left = mid + 1;  // Move towards the right half
            }
        }

        // At the end, left == right, which will be the peak element index
        return left;

    }
}
