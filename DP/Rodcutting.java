package DP;

public class Rodcutting {
    public static int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n+1][n+1];

        // Given a rod of length n(size of price) inches and an array of prices, price. 
        //price[i] denotes the value of a piece of length i. 
        //Determine the maximum value obtainable by cutting up the rod and selling the pieces
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i<=j){//validity
                    //choice                       dp[i] -> becayse of unbounded(same length rod can be cut multiple times)
                                        //include     |        //exclude
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-i], dp[i-1][j]);

                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        int price[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(cutRod(price));
    }
}
