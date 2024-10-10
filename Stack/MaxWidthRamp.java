package Stack;
import java.util.*;
public class MaxWidthRamp {
    public static int maxWidthRamp(int[] nums){
        int ans = 0;
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        for(int i=0; i<n; i++){   // to find the possible i in (i,j)-> which should be small
            if(s.isEmpty() || nums[s.peek()] >= nums[i]){
                s.push(i);   // pushing index rather than nums[i] because we want to calculate j-i(difference of indices)
            
            }
        }

        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && nums[s.peek()] <= nums[i]) {
                ans = Math.max(ans, i-s.pop());   //poping the values from the stack, 
                //because for that particular smaller value we calculated thr possible max ramp, 
                //because we started from the right(so rightmost larger value than the s.peek() is considered
                // first which can be its max ramp value also)
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {6,0,8,2,1,5};
        System.out.println(maxWidthRamp(nums));
    }
}
