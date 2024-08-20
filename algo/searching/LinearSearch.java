package searching;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Linear Search - Simple start from index 0 to n and see if the item is there
 *  Given an Array, we have to search the element
 *    if present return the index
 *    if not present return -1
 */
public class LinearSearch {


    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 80, 30, 60, 50, 110, 100, 130, 170} ;

        System.out.println( linearSearch(arr, 3) ) ;
        System.out.println( linearSearchUsingLambda(arr, 3) ) ;

    }

    public static int linearSearch(int[] arr, int key){

        for(int i =0 ; i <arr.length ; i++){
            if(arr[i]== key){
                return i + 1  ;
            }
        }

        return -1 ;
    }

    public static int linearSearchUsingLambda(int[] arr, int key){

        return IntStream.range(0, arr.length)  // Create a stream of indices
                .filter(i -> arr[i] == key)  // Filter for the index where the element matches the key
                .findFirst()  // Find the first matching element's index
                .orElse(-1);  // Return -1 if the key is not found

    }

}
