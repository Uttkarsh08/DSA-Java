import java.util.Arrays;

class Solution {
    static int MOD = 1000000007;
    public static int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        int mul = 1;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int len = j-i+1;
                if(len ==2) ans+=(nums[j]-nums[i]);
                else{
                    int n = len-2;
                    mul = (int)Math.pow(2, n) % MOD;
                    ans+=(mul * nums[j]-nums[i]) %MOD;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3};
        System.out.println(sumSubseqWidths(nums));
    }

}