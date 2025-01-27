package CP;
import java.util.Scanner;

public class CF553A {
    public static int MOD = 1000000007;
    public static int Solution(int[] arr, int n){
        long ans=1;
        int sum =arr[0];
        for(int i=1; i<n; i++){
            sum+=arr[i];
            int r = arr[i]-1;
            int N = sum-1;
            
            ans*=nCr(N, r)%MOD;
        }

        return (int)ans;
    }
    public static long nCr(int n, int r){
        if(r>n) return 0;
        if(r==0 || r==n) return 1;
        long[] dp = new long[r+1];
        dp[0] = 1;
        for(int i=1; i<=r; i++){
            dp[i] = dp[i-1]*(n-i+1) % MOD;
            dp[i] = dp[i]/i;
        }
        return (int) dp[r];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Solution(arr, n));

        sc.close();
    }
}
