package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxScore2530 {
    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num: nums){
            pq.offer(num);
        }
        long score = 0;
        while(k>0){
            int max = pq.poll();
            score+=max;
            int newElement = (max+2)/3;
            pq.offer(newElement);
            k--;
        }
        return score;

    }
    public static void main(String[] args) {
        int nums[] = {1,10,3,3,3};
        System.out.println(maxKelements(nums, 3));
    }
}
