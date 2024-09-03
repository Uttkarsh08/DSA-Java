package Greedy;

import java.util.ArrayList;

public class ActivitySelection {

    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};

        int count =0;
        ArrayList<Integer> ans = new ArrayList<>();

        // first activity is always selected
        count =1;
        ans.add(0);
        int lastEnd = end[0];

        for(int i=1; i<end.length; i++){
            if(start[i] >= lastEnd){
                ans.add(i);
                lastEnd = end[i];
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
