package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection2 {

    public static void main(String[] args) {
        int[] start = {3,1,0,8,5,5};
        int[] end =   {4,2,6,9,7,9};  //  if given non-sorted

        int count =0;
        ArrayList<Integer> ans = new ArrayList<>();

        //sorting
        int[][] activities = new int[start.length][3];    //3 clomumns -> 1 for index , 1 for start and 1 for end
        for(int i=0; i<start.length; i++){
            activities[i][0] = i; // index
            activities[i][1] = start[i];  // start
            activities[i][2] = end[i]; //end
        }
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));  // sorting on the basis of end time

        // first activity is always selected
        count =1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for(int i=1; i<end.length; i++){
            if(activities[i][1] >= lastEnd){
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
                count++;
            }
        }
        System.out.println("Maximum activities = "+ count);
        System.out.println("Activities = ");
        for(int i=0; i<ans.size(); i++){
            System.out.println("A"+ ans.get(i));
        }
    }
}
