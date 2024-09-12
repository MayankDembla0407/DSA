package searching.leetcode;

import java.util.stream.IntStream;

/**
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 */
public class L05 {

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(searchMatrix(array, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if(getIndex(row,target) != -1){
                return true ;
            }
        }
        return false ;
    }

    public static int getIndex(int[] arr, int key){
        return IntStream.range(0, arr.length)
                .filter(i -> arr[i] == key)
                .findFirst()
                .orElse(-1);
    }

}
