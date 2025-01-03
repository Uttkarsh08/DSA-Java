package DP;
import java.util.*;
public class CatlansNumber {
        public static int catlanRecursion(int n){
            if(n==0 || n==1) return 1;
            int ans=0;
            for(int i=0; i<n; i++){
                ans+=catlanRecursion(i)*catlanRecursion(n-i-1);
            }

            return ans;
        }

        public static int catlanmemo(int n, int[] dp){
            if(n==0 || n==1) return 1;
            if(dp[n] != -1) return dp[n];

            int ans=0;
            for(int i=0; i<n; i++){
                ans+= catlanmemo(i, dp)*catlanmemo(n-i-1, dp);
            }

            return dp[n] = ans;
        }

        public static int catlantabulation(int n){
            int dp[] = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;

            for(int i=2; i<=n; i++){
                int ans=0;
                for(int j=0; j<i; j++){
                    ans+=dp[j]*dp[i-j-1];
                }
                dp[i] = ans;
            }
            return dp[n];
        }


    public static void main(String[] args) {
        int n = 30;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        // System.out.println(catlanRecursion(n));
        System.out.println(catlanmemo(n, dp));
        // System.out.println(catlantabulation(n));
    }
}
