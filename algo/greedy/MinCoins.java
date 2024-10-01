package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinCoins {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 10, 20, 50, 100} ;

        System.out.println(Arrays.toString(minCoins(arr, 243))) ;

    }

    public static int[] minCoins(int[] arr, int amount ){

        Arrays.sort(arr);

        // List to store the result
        List<Integer> result = new ArrayList<>();

        while (amount > 0 ){
            int bestChoice = binarySearch(arr, amount) ;
            result.add(arr[bestChoice]) ;
            amount -= arr[bestChoice] ;
        }

        return result.stream().mapToInt(i->i).toArray();
    }

    public static int binarySearch(int[] arr, int key){
        int l = 0;
        int h = arr.length -1 ;

        while (h >= l){
            int mid = (l+h)/2 ;

            if(key == arr[mid]){
                return mid ;    // exact match
            }

            if(key > arr[mid]){
                l = mid + 1 ;
            }else {
                h = mid -1 ;
            }
        }

        return  h ;
    }


}

