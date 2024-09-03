package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class JobScheduling {
    static class Job{
        int id;
        int deadline;
        int profit;

        Job(int id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    public static void main(String[] args) {
        int[][] JobsInfo = {{4,20}, {1,10}, {1,40}, {1,30}};

        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0; i<JobsInfo.length; i++){
            jobs.add(new Job(i, JobsInfo[i][0], JobsInfo[i][1]));
        }

        Collections.sort(jobs, (a,b) -> b.profit-a.profit);  // descending order
        
        int time = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<jobs.size(); i++){
            Job cur = jobs.get(i);
            if(cur.deadline > time){
                ans.add(cur.id);
                time++;
            }
        }
        System.out.println("Maximum Jobs = " + ans.size());
        for(int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i)+" ");
        }
        System.out.println();
    }
}
