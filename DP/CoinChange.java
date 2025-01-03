package DP;

public class CoinChange {

    // Return the fewest number of coins that you need to make up that amount.
    
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        //initialization(base case)
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 0; // 0 coins needed to make amount 0
                } else if (i == 0) {
                    dp[i][j] = Integer.MAX_VALUE - 1; // Impossible to make amount with 0 coins
                }
            }
        }
        //filling
        for(int i=1; i<=n; i++){
            for(int j =1; j<=amount; j++){
                int v = coins[i-1];
                if(v<=j){//validity
                    //choices             dp[i]-> unbounded(same coin can be chosen mutiple times)
                                                //+1 -> when included 1 coin is added
                                    //include    |    //exclude(no +1 because excluded)
                    dp[i][j] = Math.min(dp[i][j-v]+1, dp[i-1][j]);

                }else{  //non - valid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount] == Integer.MAX_VALUE-1? -1: dp[n][amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5}; int amount = 11;

        System.out.println(coinChange(coins, amount));
    }
}
