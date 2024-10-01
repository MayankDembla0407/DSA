package sorting;

import java.util.Arrays;

public class quickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{10,15,1,2,9,16,11} ;

        sort(arr, 0, arr.length -1 ) ;

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr , int left, int right){

       if(right > left) {
           int partitonIndex = partition(arr, left, right);

           //recursively partition
           sort(arr, left, partitonIndex);
           sort(arr, partitonIndex + 1, right);
       }
    }


    public static int partition(int[] arr , int l, int r ){

        int pivot = arr[l] ;

        int left = l ;
        int right = r ;

        while(right > left ) {
            while (arr[left] <= pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left < right) {
                // swap
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        arr[l] = arr[right] ;
        arr[right] = pivot ;

        return right ;   // return the pivot index
    }


}
