package searching.leetcode;

/**
 * Median of Two Sorted Arrays
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class L01 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{0,0} ;
        int[] arr2 = new int[]{0,0} ;

        System.out.println(findMedian(arr1,arr2));
    }

    public static double findMedian(int[] arr1, int[] arr2){
        int m, n ;
        boolean shuffle = false;
        if(arr1.length < arr2.length){
             m = arr1.length ;
             n = arr2.length ;
        }else{
             m = arr2.length ;
             n = arr1.length ;
             shuffle = true ;
         }

        int i = 0 ;
        int j = 0 ;

        int low = 0 ;
        int high = m+1 ;
        int half = (m + n + 1) / 2 ; // where we can find the Median

         while(true) {
             int mid = (low + high) / 2;
             int xl = mid > 0 ? (shuffle ? arr2[mid-1] : arr1[mid-1]) : -433454353 ;
             int xr = mid < m ? (shuffle ? arr2[mid] : arr1[mid] ) : 324243243;
             i = mid ; // left partition
             j = half - i;

             int yl = j > 0 ? (shuffle ? arr1[j-1] : arr2[j-1]) : -433454353 ;
             int yr = j < n ? (shuffle ? arr1[j] : arr2[j]) : 345353543 ;

             if (xl <= yr && yl <= xr) { // we are good with partitioning

                 if ((m + n) % 2 == 0) { // even two digits decide median
                     return (Math.max(xl, yl) + Math.min(xr, yr)) / (double)2;
                 } else { // odd
                     return Math.max(xl, yl);
                 }
             } else {
                 if (xl > yr) { // move right
                     high = i - 1;
                 } else {
                     low = i + 1;
                 }
             }
         }
    }
}
