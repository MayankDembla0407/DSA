package greedy;

import java.util.*;

public class JobSequenceProblem {

    static class Job {
       char jobId ;
       int deadline ;
       int profit ;

       public Job(char jobId , int deadline, int profit ){
           this.jobId = jobId ;
           this.deadline = deadline ;
           this.profit = profit ;
       }

       @Override
       public String toString() {
           return "Job{" +
                   "jobId=" + jobId +
                   ", deadline=" + deadline +
                   ", profit=" + profit +
                   '}';
       }
   }

    public static void main(String[] args) {

        // Correctly initializing the ArrayList with Job objects
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job('a', 2, 27));
        jobs.add(new Job('a', 3, 100));
        jobs.add(new Job('b', 2, 19));
        jobs.add(new Job('c', 2, 25));
        jobs.add(new Job('d', 1, 15));

        JobSequenceProblem problem = new JobSequenceProblem() ;
        problem.printSelectedJob(jobs) ;
    }

    public int printSelectedJob(List<Job> jobs){

       int t = jobs.stream().mapToInt(a -> a.deadline).max().orElse(1) ;  // 3

       // Step 1 : To sort it in desc of profit
        Collections.sort(jobs, (a1,a2) -> a2.profit - a1.profit);

        // step 2 - assign
        boolean[] whenProcessed = new boolean[t] ;   // 0,1,2
        int totalprofit = 0 ;

        for(Job job : jobs){
            int td = job.deadline -1; // 2

           if(td < whenProcessed.length && !whenProcessed[td] ){
               System.out.println("Job Selected with Job: " +job );
               whenProcessed[td] = true ;
               totalprofit += job.profit ;
           }else if(td < whenProcessed.length && whenProcessed[td]){
               while (td >= 0 && whenProcessed[td]){
                   td-- ;
               }

               if(td >= 0 ) {
                   System.out.println("Job Selected with Job: " + job);
                   whenProcessed[td] = true ;
                   totalprofit += job.profit ;
               }
           }
        }
         return totalprofit ;
    }



}
