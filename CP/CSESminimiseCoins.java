package CP;
import java.util.Scanner;

public class CSESminimiseCoins {

    public static int Sol(int[] coins, int sum){
        int n = coins.length;
        int[] [] dp = new int[n+1][sum+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(j==0){
                    dp[i][j] = 0;
                }else if(i==0){
                    dp[i][j] = Integer.MAX_VALUE-1;
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if( coins[i-1]<=j){  //valid
                    int take = 1+dp[i][j-coins[i-1]];
                    int leave = dp[i-1][j];

                    dp[i][j] = Math.min(take, leave);

                }else{
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }

        return dp[n][sum] == Integer.MAX_VALUE-1? -1: dp[n][sum];
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            int[] coins = new int[n];
            for(int i=0; i<n; i++){
                coins[i] = sc.nextInt();
            }
            System.out.println(Sol(coins, x));
        }
    }
}
