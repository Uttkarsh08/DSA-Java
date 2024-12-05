package DP.Knapsack_01;

import java.util.Arrays;

public class Memoization {
    public static int knapsack(int val[], int wt[], int W, int i, int[][] dp){
        if(W==0 || i == val.length){
            return 0;
        }
        if(dp[i][W] != -1){
            return dp[i][W];
        }
        // 2 choices
        if(wt[i] <= W){
            //include
            int inc = val[i]+ knapsack(val, wt, W-wt[i], i+1, dp);

            //exclude
            int exc = knapsack(val, wt, W, i+1, dp);

            dp[i][W] = Math.max(inc, exc);
            return dp[i][W];
        }else{
            dp[i][W] = knapsack(val, wt, W, i+1, dp);
            return dp[i][W];
        }
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        int[][] dp = new int[val.length+1][W+1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(knapsack(val, wt, W, 0, dp));
    }
}
