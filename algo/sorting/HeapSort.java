package sorting;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new  int[] {38,27,43,3,9,82,10} ;

        insertToBinaryHeap(arr) ;
        deleteFromBinaryHeap(arr) ;

        System.out.println(Arrays.toString(arr));
    }

    public static void deleteFromBinaryHeap(int[] arr){

        int len = arr.length - 1 ;

        while(len > 0 ){

            int i = 0 ; // root element

            // swap with last element
            int temp = arr[i] ; // root
            arr[i] = arr[len] ; // last element
            arr[len] = temp ;
            len--;

            int leftChild = Math.min(2*i + 1 , len);
            int rightChild = Math.min(leftChild + 1,len) ;

            while(arr[i] < Math.max(arr[leftChild], arr[rightChild])){

                //swap
                int stemp =  arr[i];
                arr[i] = Math.max(arr[leftChild], arr[rightChild]) ;
                if(arr[leftChild] > arr[rightChild]){
                    arr[leftChild] = stemp ;
                    i= leftChild ;
                }else {
                    arr[rightChild] = stemp ;
                    i=rightChild ;
                }

                // update root
                leftChild = Math.min(2*i + 1 , len);
                rightChild = Math.min(leftChild + 1,len) ;
            }
        }

    }

    public static void insertToBinaryHeap(int[] arr){

        for (int i = 1 ; i < arr.length  ; i++){

            int j = i ;
            int parentIndex =  (j-1) / 2 ;

            while(j > 0 && arr[j] > arr[parentIndex]){
                // Swap if child is greater than parent
                int temp = arr[j];
                arr[j] = arr[parentIndex];
                arr[parentIndex] = temp;

                // Move Up tree
                j = parentIndex ;
                parentIndex =  (j-1)/2 ;
            }
        }
    }


}
