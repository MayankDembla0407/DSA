package searching.leetcode;

import java.util.HashSet;
import java.util.Set;

public class L16 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2} ;
        System.out.println(findDuplicate(nums)) ;
    }

    public static int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;

            // Count how many numbers are <= mid
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            // If count is greater than mid, the duplicate must be in the left half
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int findDuplicate_set(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }

        return len;
    }

}
