package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *   Given an integer array nums,
 *   return true if any value appears more than once in the array,
 *   otherwise return false.
 */

public class DuplicateInteger {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,1} ;

        System.out.println(Arrays.toString(nums));
        System.out.println(hasDuplicate(nums));
    }

    // Without Lambda using hashset O(n)
    // Space Complexity O(n) , time complexity O(n)
    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>() ;
        for (int num : nums){
           if(!set.add(num)){
              return true ;
           }
        }
        return false ;
    }


    // Space Complexity O(n) , time complexity O(n)
    public boolean hasDuplicateLambda(int[] nums) {

        Set<Integer> set = Arrays.stream(nums)// convert array to stream of Integeres
                .boxed() // converts the 'int' primitive stream of 'Integer' objects
                .collect(Collectors.toSet());

        return  set.size() < nums.length;
    }

    /**
     * Parallel streams can improve performance for CPU-bound operations but may introduce complexity and overhead in managing threads
     * @param nums
     * @return
     */
    public boolean hasDuplicateLambdaParllelStream(int[] nums) {

        Set<Integer> set = Arrays.stream(nums)// convert array to stream of Integers
                .parallel() // operations to be performed concurrently, potentially reducing processing time on multi-core processors.
                .boxed() // converts the 'int' primitive stream of 'Integer' objects
                .collect(Collectors.toSet());

        return  set.size() < nums.length;
    }

}
