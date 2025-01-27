package DP.MCMmatrixChainMul;

public class MCMtabulation {
    public static int mcm(int[] arr){
        int n = arr.length;
        int dp[][] = new int[n][n];

        //initialization(base case)
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) dp[i][j] = 0;
            }
        }
        return dp[0][n-1];
        //filling
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,3};

        System.out.println(mcm(arr));
    }
}
