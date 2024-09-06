package searching;

import java.util.stream.IntStream;

import static java.lang.Math.sqrt;

/**
 *  Slower than binary Search but suitable for slow data access like linked lists as number of iterations is less in this case.
 *  space complexity - O(sqrt(n))
 *  time complexity - O(1)
 */
public class JumpSearch {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 50, 60, 80, 100, 110, 130, 170} ;

       int result =  jumpSearchFunctionalProgram(arr, 20) ;
       int result2 =  jumpSearch(arr, 20) ;
       System.out.println(result);
       System.out.println(result2);
    }


    // Jump to Search using jump sqrt(n)
    public static  int jumpSearch(int[] arr, int key){

        int m = (int)sqrt(arr.length) ;
        for(int i = 0 ; i < arr.length ; i += m){ // jumping with m step
            if(key <= arr[i] ){
               return linearSearch(arr, Math.max((i - m), 0), i , key ) ;
            }
        }
        return -1 ;
    }

    // Regular Linear Search O(n)
    public static int linearSearch(int[] arr, int left, int right, int key){
        return  IntStream.range(left, right+1)
                .filter( i-> key == arr[i])
                .findFirst()
                .orElse(-1) ;
    }


     // Using Lambda

    public static int jumpSearchFunctionalProgram(int[] arr, int key){

        int step = (int) Math.sqrt(arr.length) ;
        int n = arr.length;

        int stepInit = IntStream.iterate(0, i -> i + step)
                .limit(n/step + 1 ) // max steps
                .filter(i -> arr[i] >= key)
                .findFirst()
                .orElse(-1);


        return stepInit != -1 ? linearSearch(arr,Math.max(stepInit - step,0) , stepInit, key) : -1 ;

    }


}
