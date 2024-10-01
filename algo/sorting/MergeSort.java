package sorting;


import java.util.Arrays;

/**
 *
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = new int[]{15,5,24,8,1,3,16,10,20} ;
        mergeSort(arr, 0 , arr.length-1) ;
        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr, int l , int r ){

        if (l < r ) {
            int mid = (l + r) / 2;

            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] arr , int l , int mid , int r ){

        int n1 = mid - l  +1 ;
        int n2 = r - mid ;

        int[] left = new int[n1] ;
        int[] right = new int[n2] ;

        System.arraycopy(arr, l , left , 0 , n1);
        System.arraycopy(arr, mid+1, right, 0 , n2 );

        int i = 0 , j = 0 ;
        int k = l ;

        while (i < n1 && j < n2  ){

            if(left[i] <= right[j]){
                arr[k] = left[i] ;
                i++ ;
                k++ ;
            }else {
                arr[k] = right[j] ;
                j++;
                k++ ;
            }
        }

        // copy rest
        while (i < n1){
            arr[k] = left[i] ;
            i++;
            k++ ;
        }

        while (j < n2){
            arr[k] = right[j] ;
            j++;
            k++ ;
        }
    }
}
