package CP;

import java.util.Scanner;

public class CSESdiceCombination {
    static int MOD = 1000000007;
    static int sol(int n){
        int[] dp= new int[n+1];
        dp[0] =  1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=6 && j<=i; j++){
                dp[i] = (dp[i]+dp[i-j]) % MOD;
            }
        }

        return dp[n];
        
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            System.out.println(sol(n));
        }
    }
}
