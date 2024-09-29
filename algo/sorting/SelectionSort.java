package sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{64,25,12,22,11} ;

        selectionSort(arr) ;
        System.out.printf(Arrays.toString(arr));

    }

    public static void selectionSort(int[] arr){

        for(int i = 0 ; i < arr.length-1 ; i++){
            int mi = i ;
            for(int j = i+1 ; j < arr.length ; j++){
                if(arr[j] < arr[mi]){
                    mi = j ;
                }
            }

            // swap
            int temp = arr[i];
            arr[i]= arr[mi] ;
            arr[mi] = temp ;

        }
    }


}
