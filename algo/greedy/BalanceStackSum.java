package greedy;

import java.util.Stack;

public class BalanceStackSum {


    public static void main(String[] args) {

        Stack<Integer> stack1 = new Stack<>() ;
        stack1.push(3) ;
        stack1.push(2) ;
        stack1.push(4) ;
        Stack<Integer> stack2 = new Stack<>() ;
        stack2.push(3) ;
        stack2.push(2) ;
        stack2.push(1) ;
        stack2.push(1) ;
        Stack<Integer> stack3 = new Stack<>() ;
        stack3.push(4) ;
        stack3.push(1) ;

        System.out.println(getBalanceEqualSum(stack1,stack2,stack3));

    }

    private static int getBalanceEqualSum(Stack<Integer> stack1 , Stack<Integer> stack2,
                                          Stack<Integer> stack3){

        int sum1 = getStackSum(stack1 );
        int sum2 = getStackSum(stack2 );
        int sum3 = getStackSum(stack3 );

        while(!stack1.isEmpty() && !stack2.isEmpty() && !stack3.isEmpty()){
            if(sum1 == sum2 && sum2==sum3){
                return sum1 ;
            }

            //
            if(sum1 > sum2 && sum1 > sum3){
                sum1 -= stack1.pop() ;
            }else if(sum2 > sum1 && sum2 > sum3){
                sum2 -= stack2.pop() ;
            }else if( sum3 > sum1 && sum3 > sum2){
                sum3 -= stack3.pop() ;
            }
        }

        return 0 ;
    }

    private  static int getStackSum(Stack<Integer> stack){
       return stack.stream().mapToInt(Integer::intValue).sum() ;
    }



}
