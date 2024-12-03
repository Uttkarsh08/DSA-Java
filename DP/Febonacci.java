package DP;

public class Febonacci {

    public static int fiboMemoization(int n , int[] dp){
        if(n==0 || n==1) return n;
        if(dp[n] != 0) return dp[n];

        dp[n] = fiboMemoization(n-1, dp)+fiboMemoization(n-2, dp);
        return dp[n];
    }

    public static int fiboTabulation(int n){
        int[] dp = new int[n+1];
        dp[0] =0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];

        System.out.println(fiboMemoization(n, dp));
        System.out.println(fiboTabulation(n));
    }
}
