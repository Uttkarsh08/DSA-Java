package DP;

public class ClimbingStairs {
    public static int countWays(int n){
        if(n==0 || n==1) return 1;
        return countWays(n-1)+countWays(n-2);
    }
    public static int countWaysMemoization(int n, int[] dp){
        if(n==0 || n==1) return 1;
        if(dp[n]!= 0) return dp[n];

        dp[n] = countWaysMemoization(n-1, dp)+countWaysMemoization(n-2, dp);
        return dp[n];
    }

    public static int countWaysTabulation(int n){
        int[] dp = new int[n+1];
        dp[0] =1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        System.out.println(countWays(n));
        System.out.println(countWaysMemoization(n, dp));
        System.out.println(countWaysTabulation(n));
    }
}
