import java.util.*;

import javax.swing.tree.TreeNode;

public class Helper {
    public static int maximumSwap(int num) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) {
                return b[0] - a[0];  // Prefer larger digit
            } else {
                return a[1] - b[1];  // If digits are the same, prefer larger index (later occurrence)
            }
        });
        String numStr = String.valueOf(num);
        int[] digits = new int[numStr.length()];

        for (int i = 0; i < digits.length; i++) {
            digits[i] = numStr.charAt(i) - '0';  // Convert each char to an integer
        }


        for(int i=0; i<numStr.length(); i++){
            pq.offer(new int[]{digits[i], i});
        }
        int i=0;
        while(pq.peek()[0] == digits[i]){
            pq.poll();
            if(pq.isEmpty()) break;
            i++;
            
        }
        if(!pq.isEmpty()){
            int[] max = pq.poll();
            int temp = digits[i];
            digits[i] = max[0];
            digits[max[1]] = temp;
        }
        
        int number = 0;
        for (int digit : digits) {
            number = number * 10 + digit;
        }

        return number;
            
    }   
    
    public static void main(String[] args) {
        int nums = 98368;
        
        System.out.println(maximumSwap(nums));
    }
}

