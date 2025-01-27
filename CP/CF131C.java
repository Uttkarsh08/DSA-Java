package CP;

import java.util.Scanner;

public class CF131C {

    public static long Solution(int n, int m, int t) {
        long valid = 0;

        for (int boys = 4; boys < t; boys++) {
            int girls = t - boys;
            if (boys <= n && girls <= m && girls >= 1) {
                valid += nCr(n, boys) * nCr(m, girls);
            }
        }

        return valid;
    }
    public static long Solution2(int n, int m, int t) {
        long total= nCr(n+m, t);
        long invalid = 0;

        for (int boys = 0; boys <=3; boys++) {
            int girls = t - boys; 
            if (boys <= n && girls <= m) {
                invalid += nCr(n, boys) * nCr(m, girls);
            }
            
        }
        int girls = 0;
        int boys = t;
        if (boys <= n && girls <= m) {
            invalid += nCr(n, boys) * nCr(m, girls);
        }
        

        return total - invalid;
    }

    public static long nCr(int n, int r){
        if(r>n) return 0;
        if(r==0 || r==n) return 1;
        long[] dp = new long[r+1];
        dp[0] = 1;
        for(int i=1; i<=r; i++){
            dp[i] = (dp[i-1]*(n-i+1)/i);
        }
        return dp[r];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();

        System.out.println(Solution2(n, m, t));

        sc.close();
    }
}
