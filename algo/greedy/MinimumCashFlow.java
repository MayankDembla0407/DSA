package greedy;

import java.util.Arrays;

public class MinimumCashFlow {

    public static void main(String[] args) {

        int[][] flow = new int[][]{
                {0,500,1000,0},
                {0,0,200,700},
                {0,0,0,400},
                {0,0,0,0}

        } ;

//        System.out.println(findMax(getNetIncome(flow)));
        findMinCashFlow(getNetIncome(flow)) ;
    }


    private static void findMinCashFlow(int[] netIncome){

        int minIndex = findMin(netIncome) ;
        int maxindex = findMax(netIncome) ;

        if(netIncome[minIndex] == 0 && netIncome[maxindex] == 0){
            return ;
        }

        int min = Math.min(-netIncome[minIndex] , netIncome[maxindex] ) ;

        netIncome[minIndex] += min ;
        netIncome[maxindex] -= min ;

        System.out.println("Person " + maxindex + " pays " + min + " to Person " + minIndex);

        findMinCashFlow(netIncome) ;
    }


    private static int findMin(int[] netIncome){
        int min = 0 ;
        for(int i = 0 ; i < netIncome.length ; i++){
            if(netIncome[i] < netIncome[min]){
                min = i ; // storing index
            }
        }
        return min ;
    }

    private static int findMax(int[] netIncome){
        int max = 0 ;
        for(int i = 0 ; i < netIncome.length ; i++){
            if(netIncome[i] > netIncome[max]){
                max = i ; // storing index
            }
        }
        return max ;
    }

    private static int[] getNetIncome(int[][] flow){

        int[] netIncome = new int[flow.length];

        for(int i = 0 ; i < flow.length ; i++){
            for(int j = 0 ; j < flow.length ; j++){
                netIncome[i] += flow[j][i] - flow[i][j] ;
            }
        }

        return netIncome ;
    }

}
