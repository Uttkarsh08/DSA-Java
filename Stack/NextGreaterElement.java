package Stack;

import java.util.*;

public class NextGreaterElement {
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[nums.length];

        for(int i= nums.length-1; i>=0; i--){
            while(!s.isEmpty() && s.peek() <= nums[i]){
                s.pop();
            }   
            if(s.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = s.peek();
            }
            s.push(nums[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {6,8,0,1,3};
        int[] anss = nextGreaterElements(nums);

        for(int a : anss){
            System.out.print(a + " ");
        }
    }
}
