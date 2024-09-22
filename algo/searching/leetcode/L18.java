package searching.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given two integer arrays nums1 and nums2, return an array of their
 * intersection
 * . Each element in the result must be unique and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 */
public class L18 {

    public static void main(String[] args) {

        // Example 1
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(getIntersection(nums1, nums2)));  // Output: [2]

        // Example 2
        int[] nums1_2 = {4, 9, 5};
        int[] nums2_2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(getIntersection(nums1_2, nums2_2)));  // Out

    }

    public static int[] getIntersectionelements(int[] arr, int[] arr2) {

        Set<Integer> darr = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        Set<Integer> resultArray = Arrays.stream(arr2)
                .filter(darr::contains)
                .boxed()
                .collect(Collectors.toSet());

        return resultArray.stream().mapToInt(Integer::intValue).toArray() ;
    }

    public static int[] getIntersection(int[] arr, int[] arr2){

        Set<Integer> seta = new HashSet<>() ;

        for (int num : arr){
            seta.add(num) ;
        }

        Set<Integer> result = new HashSet<>() ;

        for(int num : arr2){
            if(seta.contains(num)){
                result.add(num) ;
            }
        }

        return  result.stream().mapToInt(Integer::intValue).toArray() ;
    }

}
