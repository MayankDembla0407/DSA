package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{38,27,43,3,9,82,10} ;
        bubbleSort(arr) ;
        System.out.printf(Arrays.toString(arr));
    }


    public static void bubbleSort(int[] arr){

        for (int i = 0 ; i <arr.length ; i++){
            for(int j = 0 ; j < arr.length - 1 -  i ; j++ ){
                if(arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j+1] ;
                    arr[j+1] = arr[j] ;
                    arr[j] = temp ;
                }
            }
        }
    }


}
