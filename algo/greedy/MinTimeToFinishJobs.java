package greedy;


import java.util.Arrays;

/**
 * Given a jobs arrays  - jobs
 *  given K - workers
 *  given T- time for 1 unit to the worker
 */
public class MinTimeToFinishJobs {

    public static void main(String[] args) {
        int k1 = 4 ;
        int t1 = 5 ;
        int[] jobs ={10,7,8,12,6,8} ;

        System.out.println(findMinTime(jobs, k1) * t1);
    }

    private static int findMinTime(int[] jobs , int k ){

        int min = Arrays.stream(jobs).min().orElse(0) ;
        int max = Arrays.stream(jobs).sum() ;
        int result = 0 ;

        while (max >= min ) {
            int mid = (min + max) / 2 ;
            if (isValidAssignment(jobs, k, mid)) {
                result = mid ; // min time found
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
      return result ;
    }

    private static  boolean isValidAssignment(int[] jobs , int k , int max ){

        int sum = 0 ;
        int worker = 1 ;

        for (int job : jobs){
            sum += job ;

            if(sum > max ){
               worker++ ;
               sum = job ;
            }

            if(worker > k){
                return false ; // not possible to assign this weight to assignee
            }
        }
        return true ; // possible to assign this weight to assignee
    }
}
