import java.util.*;

import javax.swing.tree.TreeNode;

public class Helper {
    public static int maxWidthRamp(int[] nums) {
        int sum = 0;
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(s.isEmpty() || nums[s.peek()] >= nums[i]){
                s.push(i);
            }
        }
        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && nums[s.peek()] <= nums[i]){
                sum = Math.max(sum, i-s.pop());
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> path1 = new ArrayList<>();
        path1.add(1);
        path1.add(2);

        int[] nums = {6,0,8,2,1,5};
        System.out.println(path1.get(2));
    }
}

