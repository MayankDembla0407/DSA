package searching;

import java.util.function.IntBinaryOperator;

/**
 * Binary Search
 *   Given an array and a key , search the key and return the index, if not present return -1
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[]{10, 20, 30, 50, 60, 80, 100, 110, 130, 170} ;

        System.out.println("Testing indexes");

        // positive cases
        for (int j : arr) {
            int index = binarySearch(arr, 0, arr.length - 1, j);
            System.out.println(j + " Searched key found at : " + index);
        }

        // negative case
        int index = binarySearch(arr, 0 , arr.length-1 , 10323) ;
        System.out.println(10323 + " Searched key found at : " + index);


        System.out.println(0 + " Searched key found at : "
                + binarySearch(arr, 0 , arr.length-1 , 0));

        System.out.println("==== using non recursive solution ====== ");

        for (int j =0 ; j <arr.length ; j++) {
            System.out.println(arr[j] + " searched key index " + binarySearchNonRecursive(arr, j)) ;
        }

        System.out.println(10123 + " searched key index " + binarySearchNonRecursive(arr, 10123)) ;
        System.out.println(0 + " searched key index " + binarySearchNonRecursive(arr, 0)) ;

        System.out.println("==== using Lambda solution ====== ");

        for (int j =0 ; j <arr.length ; j++) {
            System.out.println(arr[j] + " searched key index " + binarySearchLambda(arr, j)) ;
        }

        System.out.println(10123 + " searched key index " + binarySearchLambda(arr, 10123)) ;
        System.out.println(0 + " searched key index " + binarySearchLambda(arr, 0)) ;

    }

    /**
     *  Binary Search - Array should be sorted.
     * @param arr - array
     * @param key - key to search
     * @return - index
     */
    public static int binarySearch(int[] arr,int left, int right, int key){

       if(right >= left ) {
           int mid = (left + right) / 2;

           if (arr[mid] == key) {
               return mid;
           }

           if (arr[mid] < key) {
               return binarySearch(arr, mid + 1, right, key);
           } else {
               return binarySearch(arr, left, mid - 1, key);
           }
       }

       return  -1 ;
    }

    /**
     * Binary Search - should be sorted array
     * @param arr - sorted array
     * @param key - key
     * @return - index
     */
    public static int binarySearchNonRecursive(int[] arr, int key){

        int left = 0 ;
        int right = arr.length -1 ;

        while(right >= left ){
            int mid = (left + right) / 2 ;

            if(arr[mid] == key){
                return  mid ;
            }

            if(arr[mid] > key ){
                right = mid - 1 ;
            } else if (arr[mid] < key){
                left = mid + 1 ;
            }
        }

        return -1 ;

    }

    /**
     * Using the IntBinary Operator
     * @param arr - array
     * @param key - key
     * @return - index
     */
    public static int binarySearchLambda(int[] arr, int key){
        IntBinaryOperator intBinaryOperator = new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                if(left <= right){
                    int  mid = (left + right) / 2 ;
                    if(arr[mid] > key){
                        applyAsInt(left, mid -1 ) ;
                    }else if(arr[mid] < key){
                        applyAsInt(mid+1, right) ;
                    }
                }
                return -1;
            }
        } ;

       return intBinaryOperator.applyAsInt(0, arr.length-1) ;
    }

}
