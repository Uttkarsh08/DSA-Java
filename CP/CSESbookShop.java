package CP;
import java.util.Scanner;

public class CSESbookShop {
    public static int Sol(int n, int x, int[] prices, int[] pages){
        int[][] dp = new int[2][x+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=x; j++){
                if(prices[i-1] <=j){ //valid
                    int take = pages[i-1] + dp[(i-1)%2][j-prices[i-1]];
                    int leave =dp[(i-1)%2][j];
                    dp[i%2][j] = Math.max(take, leave);
                }else{
                    dp[i%2][j] = dp[(i-1)%2][j];
                }
            }
        }

        return dp[n%2][x];
    }
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] prices = new int[n];
        for(int i=0; i<n; i++){
            prices[i] = sc.nextInt();
        }

        int[] pages = new int[n];
        for(int i=0; i<n; i++){
            pages[i] = sc.nextInt();
        }

        System.out.println(Sol(n, x, prices, pages));

    }
}
