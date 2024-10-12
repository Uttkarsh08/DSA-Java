package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinGroups2046 {
    public static int minGroups(int[][] intervals) {
        int group = 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return a[0]-b[0];   
            }
        });
        PriorityQueue<int[]> occupied = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return a[1]-b[1];
            }
        });

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];

            while(!occupied.isEmpty() && start > occupied.peek()[1]){
                occupied.poll();
            }
            occupied.offer(new int[]{start, end});
            group = Math.max(group, occupied.size());
        }
        

        return group;
    }
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
            {5, 10}, 
            {6, 8}, 
            {1, 5}, 
            {2, 3}, 
            {1, 10}
        };

        System.out.println(minGroups(intervals));
    }
}
