package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinRange632 {
    public static int[] smallestRange(List<List<Integer>> nums) {
        //min heap
        //[element, listIndex, elementIndex]

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int a[], int b[]){
                return a[0]-b[0];
            }
        });
        int k = nums.size();
        int max = Integer.MIN_VALUE;

        //add first element of each list in pq
        for(int i=0; i<k; i++){
            int minVal = nums.get(i).get(0);
            pq.offer(new int[]{minVal, i, 0});
            max = Math.max(max, minVal);  // we got max to compare
        }
        int[] minRange = {0, Integer.MAX_VALUE};
        while(true){
            int top[] = pq.poll();
            int minelement = top[0]; int listIndex = top[1]; int elementIndex = top[2];
            if(max-minelement < minRange[1]-minRange[0]){
                minRange[0] = minelement;
                minRange[1] = max;
            }
            if(elementIndex == nums.get(listIndex).size()-1) break; // if it is last element of any list from k lists

            int next = nums.get(listIndex).get(elementIndex+1);
            max = Math.max(max, next);
            pq.offer(new int[]{next, listIndex, elementIndex+1});
        }
        return minRange;
    }
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20)); 
        nums.add(Arrays.asList(5, 18, 22, 30));

        System.out.println();
    }
}
