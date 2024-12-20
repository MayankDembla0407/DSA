package searching.leetcode;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example 1:
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * Example 2:
 * Input: n = 1, bad = 1
 * Output: 1
 */
public class L15 {

    public static final int BAD_VERSION = 4 ;

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5)) ;
    }

    public static int firstBadVersion(int n) {
        int l = 1 ;
        int h = n ;

        while(h != l ){
            int mid = l + (h-l)/2 ;

            if(!isBadVersion(n, mid)){
                l = mid +1 ;
            }else {
                h = mid ;
            }
        }
        return l ;
    }

    public static boolean isBadVersion(int n, int loc){

        boolean[] versions = new boolean[n] ;

        for (int i = 0 ; i < n ; i++){
            if(i >= BAD_VERSION){
                versions[i] = true ;
            }else {
                versions[i] = false ;
            }
        }

       return versions[loc] ;
    }


}
