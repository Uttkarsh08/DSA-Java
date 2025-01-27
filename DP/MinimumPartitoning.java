package DP;

public class MinimumPartitoning {
    //variation of 0-1 knapsack
    public static int Minpart(int arr[]){
        int n = arr.length;
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=arr[i];
        }
        int W = sum/2;
        int[][] dp = new int[n+1][W+1];

        //initialization  (willl be 0 for first row and col)
        
        //filling
        for(int i=1; i<=n; i++){
            for(int j=1; j<=W; j++){
                int val = arr[i-1];

                if(val <=j){ //validity
                    //include
                    int inc = val+dp[i-1][j-val];
                    int exc = dp[i-1][j];

                    dp[i][j] = Math.max(inc, exc);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum-sum1;

        return Math.abs(sum2- sum1);

    }
    public static void main(String[] args) {
        int arr[] = {1,6,11,5};

        System.out.println(Minpart(arr));
    }
}
