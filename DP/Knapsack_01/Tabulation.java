package DP.Knapsack_01;

public class Tabulation {

    public static int knapsack(int val[], int wt[], int W){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=W; j++){
                int v = val[i-1];  //ith item value
                int w = wt[i-1];

                if(w<= j){   // valid case
                    //include
                    int incProfit = v+dp[i-1][j-w]; 

                    //exclude
                    int excprofit = dp[i-1][j];

                    dp[i][j] = Math.max(incProfit, excprofit);

                }else{     // when not valid, always exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];

    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        System.out.println(knapsack(val, wt, W));
    }
}
