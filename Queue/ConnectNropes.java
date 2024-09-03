package Queue;

import java.util.PriorityQueue;

public class ConnectNropes {
    public static long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> pq= new PriorityQueue<Long>();
        
        for(int i=0; i<n; i++){
            pq.add(arr[i]);
        }
        
        int ans = 0;
        while(pq.size() > 1){
            long first = pq.poll();
            long second = pq.poll();
            ans+=first+second;
            pq.add(first+second);
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        long arr[] = {4, 3, 2, 6};
        System.out.println(minCost(arr, n));
    }
}
