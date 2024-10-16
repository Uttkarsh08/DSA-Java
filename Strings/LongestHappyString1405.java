import java.util.PriorityQueue;

public class LongestHappyString1405 {
    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> y[1]-x[1]);
        StringBuilder ans = new StringBuilder();
        if(a>0) pq.offer(new int[]{'a',a});
        if(b>0) pq.offer(new int[]{'b',b});
        if(c>0) pq.offer(new int[]{'c',c});

        while(!pq.isEmpty()){
            int[] max = pq.poll();
            if(ans.length() >=2 && max[0] == ans.charAt(ans.length()-1) && max[0] == ans.charAt(ans.length()-2)){

                if(pq.isEmpty()) break;

                int[] secondmax = pq.poll();
                ans.append((char)secondmax[0]);
                secondmax[1]--;
                if(secondmax[1] > 0)pq.offer(secondmax);
                pq.offer(max);
            }else{
                ans.append((char)max[0]);
                max[1]--;
                if(max[1] > 0)pq.offer(max);
            }

        }
        return ans.toString();
    }
    public static void main(String[] args) {
        int a = 7; int b = 1; int c = 0;
        System.out.println(longestDiverseString(a, b, c));
    }
}
