package greedy;

import java.util.Arrays;

public class AlternativeActivityProblem {


    static class Activity{
        int startTime, endTime ;

        public Activity(int startTime, int endTime){
            this.endTime = endTime ;
            this.startTime = startTime ;
        }
    }

    public static void  selectActivities(Activity[] activities){

        Arrays.sort(activities, (a1,a2) -> a1.endTime - a2.endTime) ;

        int lastSelectedEnd = -1 ;

        for(int i = 0 ; i < activities.length ; i++){
            if(activities[i].startTime >= lastSelectedEnd ){
                System.out.println("Activity Selected : start : " + activities[i].startTime + " EndTime : " + activities[i].endTime);
                lastSelectedEnd = activities[i].endTime ;
            }
        }
    }

    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1, 2),
                new Activity(3, 4),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(8, 9),
                new Activity(5, 9)
        };

        selectActivities(activities);
    }
}
