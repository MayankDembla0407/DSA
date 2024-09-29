package sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{38,27,43,3,9,82,10} ;
        insertionSort(arr);
        System.out.print(Arrays.toString(arr));

    }

    public static void insertionSort(int[] arr){
        for(int i = 1 ; i < arr.length ; i++){
           int key = arr[i] ;
           int j = i-1 ;
           while(j >= 0 && key < arr[j]){
               arr[j+1] = arr[j] ;
               j--;
           }
            arr[j + 1] = key;
        }
    }



}
